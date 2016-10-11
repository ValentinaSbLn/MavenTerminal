import java.util.Scanner;

/**
 * Created by Valentina on 08.10.2016.
 */
public class TerminalInterface {


    public static void main(String[] args) {

        // TODO Метод стоит поделить на отдельные логические части.
        // В данном виде в нём присутствует смешивание различных действий. На 1 метод 1 логическое действие.
        // Ошибка в дизайне метода привела к необходимости множественого написания System.exit();

        System.out.println("Для начала работы с термналом необходимо ввести номер счета и пин код");
        TermUsr trm = new TermUsr();

        boolean check = false;
        try {
            trm.setNumAccount(Integer.parseInt(trm.readConsol("Введите номер счета")));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат");
            System.exit(0);
        }
        try {
            check = trm.enterPin();
        } catch (AccountIsLockedException e) {
            // e.printStackTrace();
        }
        TerminalImpl terminal = new TerminalImpl(check, trm.getNumAccount());

        System.out.println("\nТерминал приветствует вас");
        String select = "n";
        do {
            System.out.println("\nВыберите действие:\n0- Выход \n1- Запрос баланса \n2- Пополнить баланс \n3- Снять наличные ");

            // TODO Есть такой паттерн - command. Он бы здесь очень подошёл.
            // С ним бы не пришлось иметь проблемы, например, со случаем выхода из системы (ввод 0).
            // + в таком виде выход из системы делать не совсем красиво.
            // Можно, например, сделать labeled loop (https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html)
            Scanner in = new Scanner(System.in);
            select = in.nextLine();
            switch (select) {
                case "0":
                    System.out.println("До свидания");
                    System.exit(0);
                case "1":
                    try {
                        terminal.printBalance();
                    } catch (InvalidPinException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        double deposit = Double.parseDouble(trm.readConsol("Введите сумму, которую вы желаете положить"));
                        terminal.putMoney(deposit);
                    } catch (NumberFormatException e) {
                        System.out.println("Вы ввели не число");
                    }

                    break;
                case "3":
                    double withdraw = Double.parseDouble(trm.readConsol("Введите сумму, которую вы желаете положить"));

                    terminal.takeMoney(withdraw);
                    break;
                default:
                    System.out.println("Введен неверный символ");
            }

        } while (!select.equals("0"));

    }
}
