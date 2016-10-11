/**
 * Created by Valentina on 08.10.2016.
 */
import java.util.Timer;
import java.util.TimerTask;

/**
 * Исключение выбрасывается, когда пользователь три раза неправильно вводит ПИН код
 */
public class AccountIsLockedException extends Exception {
    private static final long serialVersionUID = -2586414477138775105L;

    AccountIsLockedException() {
        // TODO Нельзя смешивать работу с пользовательским интерфейсом и классом исключения.
        // Исключение лишь должно содержать описание произошедшего исключительного события.
        System.out.println("Вы неправильно ввели PIN три раза. Терминал будет заблокирован на 5 секунд, после чего можете повторить ввод PIN");
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {  // TODO TimerTask'и лучше не использовать
            int i = 5;

            public void run() {
                System.out.println("Повторная попытка возможна через: " + i--);
                if (i < 0)
                    timer.cancel();
            }
        }, 0, 1000);

        // TODO Таймер здесь не нужен. Висит целый поток под него.
        // Достаточно в момент 3-ей неудачной попытки сохранить время её возникновения + 5 секунд (время наступления разблокировки).
        // В таком случае достаточно будет проверить текущее время в момент следующей попытки ввода и сохранённое значение времени разблокировки.
    }

    AccountIsLockedException(Throwable cause) {
        super(cause);
    }
}
