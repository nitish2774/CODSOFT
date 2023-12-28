import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

class CurrencyConverter {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency code: ");
        String targetCurrencyCode = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String baseCurrencyCode = scanner.next().toUpperCase();
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        double convertedAmount = convertCurrency(amount, baseCurrencyCode, targetCurrencyCode);
        System.out.printf("%s %.2f is equal to %s %.2f%n",
                getCurrencySymbol(baseCurrencyCode), amount,
                getCurrencySymbol(targetCurrencyCode), convertedAmount);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrencyCode, String targetCurrencyCode) {
        return amount * 2;
    }

    private static String getCurrencySymbol(String currencyCode) {
        try {
            Currency currency = Currency.getInstance(currencyCode);
            return currency.getSymbol();
        } catch (IllegalArgumentException e) {
            return currencyCode; 
        }
    }
}
