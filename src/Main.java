import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    static ArrayList<Candle> candleArrayList = new ArrayList<>();
    static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void main(String[] args) {
        candleArrayList.add(new Candle("Cinnamon Apple", 10, 20.95));
        candleArrayList.add(new Candle("Pumpkin Spice", 7.77, 8.27));
        candleArrayList.add(new Candle("Peppermint", 4.8, 5.35));
        double totalBurn = 0;
        double totalDollarBurn = 0;
        double totalPrice = 0;
        promptInput();

        String receipt = "";
        String divider = "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        for (int i = 0; i < candleArrayList.size(); i++) {

            Candle temp = candleArrayList.get(i);
            if (temp.getQuantity() > 0) {
                receipt += divider + "\n" + temp.getName() + "\n Amount: " + temp.getQuantity() + "\n Burn Time: " + temp.getBurnTime()
                        + "\n Dollar per burn time: " + decimalFormat.format(temp.getDollarBurnTime()) + "\n price: " + decimalFormat.format(temp.getPrice() * temp.getQuantity());
                totalBurn += temp.getBurnTime();
                totalDollarBurn += temp.getDollarBurnTime();
                totalPrice += temp.getPrice();
            }
        }

        receipt += divider + "\n Total Burn Time: " + decimalFormat.format(totalBurn) + "\n Total Dollar per Burn Time: " + decimalFormat.format(totalDollarBurn) + "\n Total Price: " + decimalFormat.format(totalPrice);
        System.out.println(receipt);
    }


    static public void promptInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Yonathan's Candle shop! Care to buy a candle?" +
                "\n ( Enter a number)" +
                "\n 1. Cinnamon Apple Candle \n 2. Pumpkin Spice Candle \n 3. Peppermint Candle");
        int selection = Integer.parseInt(scanner.nextLine());
        System.out.println("How many candles would you like? (Enter a whole number please)");
        int quantity = Integer.parseInt(scanner.nextLine());

        switch (selection) {
            case 1:
                candleArrayList.get(0).setQuantity(quantity);
                break;

            case 2:
                candleArrayList.get(1).setQuantity(quantity);

                break;

            case 3:
                candleArrayList.get(2).setQuantity(quantity);

                break;

            default:
                break;
        }

        System.out.println("Would you like to make another purchase? (Y = 1, N = 0");
        int yesNo = Integer.parseInt(scanner.nextLine());

        if (yesNo > 0) {
            promptInput();
        } else {
            return;
        }


        //scanner.close();
    }


}