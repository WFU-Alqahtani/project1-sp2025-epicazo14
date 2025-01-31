import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item[] storeMenu = setupStore();
        ArrayList<Item> cartInventory2 = createCart(storeMenu, args);
        printReceiptInOrder(cartInventory2);
        emptyCartReverseOrder(cartInventory2);
    }
    //Creates the array to simulate the store's inventory
    public static Item[] setupStore(){
     Item[] storeInventory = new Item[5];
    storeInventory[0] = new Item("Water",1.5);
    storeInventory[1] = new Item("Apple",2.0);
    storeInventory[2] = new Item("Juice", 3.0);
    storeInventory[3] = new Item("Chips", 2.5);
    storeInventory[4] = new Item("Candy", 4.0);
    return storeInventory;
    }

    //Creates arrayList that will simulate the User cart and store all the arguments from the command line
    public static ArrayList<Item> createCart(Item[] inventory,String[] args) {
        ArrayList<Item> cartInventory = new ArrayList<Item>();
        int item = 0;
        for (int i = 0; i < args.length; i++) {
            try {
                item = Integer.parseInt(args[i]);
                cartInventory.add(inventory[item]);
                //The program checks for bad input and if there is any valid input to continue running
            } catch (NumberFormatException e) {
                System.out.println(e + " Is not a valid number");
            }catch (ArrayIndexOutOfBoundsException f) {
                System.out.println(f + " Is not a valid number");
            }
        }
        if(cartInventory.size() == 0){
            System.out.println("No valid input in cart!");
            System.exit(0);
        }
        return cartInventory;
    }
    //The program will print a receipt and use variables to calculate the subtotal and total of the users cart
    public static void printReceiptInOrder(ArrayList<Item> userCart) {
    System.out.println("Receipt:\n══════════════════════════════════════\nItem:             Price:");
    String itemName = "";
    double itemPrice = 0;
    double subtotalPrice = 0;

    for(int i= 0; i<userCart.size(); i++) {
        itemName = userCart.get(i).getItemName();
        itemPrice = userCart.get(i).getItemPrice();
        subtotalPrice += itemPrice;
        System.out.println(itemName + "              " + itemPrice);
    }

    System.out.println("══════════════════════════════════════");
    System.out.println("SUBTOTAL: " + subtotalPrice );
    System.out.println("SALES TAX: 5%");
    System.out.print("TOTAL: ");
    System.out.printf("%.2f\n",subtotalPrice + ((subtotalPrice/100) * 5));
    }
    //The program will display and remove each item in the user's cart in reverse order of addition to the cart
    public static void emptyCartReverseOrder(ArrayList<Item> userCart) {
        System.out.println("Removing items from cart in reverse order... ");

        for(int i = 0; i<userCart.size(); i++) {
            System.out.println("Removing: " + userCart.get(i).getItemName());
        }
        System.out.print("Cart has been emptied!");
    }
}



