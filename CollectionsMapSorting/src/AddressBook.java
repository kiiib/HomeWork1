import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.Comparator;
public class AddressBook {
    //private List<Contact> contacts = new ArrayList<Contact>(); // 聯絡人列表
    //private Map<String, Contact> contacts = new HashMap<String, Contact>();
    private Map<String, Contact> contacts = new TreeMap<String, Contact>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 程式進入點
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        String input; 
        do {
            showMenu(); // 顯示選單
            input = scanner.next();
            System.out.println();
            
            switch (input) {
            case "1": // 新增聯絡人
                addressBook.addContact();
                break;
            case "2": // 顯示聯絡人列表
                addressBook.showContacts();
                break;
            case "3": // Edit the Contact
                addressBook.editContacts();
                break;
            case "4": // Delete the Contact
                addressBook.deleteContacts();
                break;
            case "5": // Import Contacts
                addressBook.importContacts();
                break;
            case "6": // Export Contacts
                addressBook.exportContacts();
                break;
            case "7": // 清除聯絡人列表
                addressBook.clearList();
                break;
            }
            
            System.out.println();
        } while (!input.equals("0"));
    }

    /**
     * 顯示選單
     */
    public static void showMenu() {
        System.out.println("***** Address Book *****");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit the Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contacts");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("************************");
        System.out.print("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }

    /**
     * 新增聯絡人
     */
    public void addContact() {        
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Birthday(yyyy/MM/dd): ");
        String birthdayString = scanner.next();

        // 驗證輸入格式
        if (isValidFormat(name, birthdayString, phone, email)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            Date birthday = null; // 宣告Date物件
            try {
                birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                //contacts.add(new Contact(name, birthday, phone, email)); // 加入聯絡人
                contacts.put(name, new Contact(name, birthday, phone, email));
                System.out.println("The contact has been added.");
                //Collections.sort(contacts); // 排序(按出生日期)
            } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                e.printStackTrace(); // 顯示堆疊追蹤
            }
        }
    }

    /**
     * 顯示聯絡人列表
     */
    public void showContacts() {
        System.out.printf("The contact list is sorted by [1:Name 2:Birthday 3:Phone 4:E-mail]:");
        String inputSorting = scanner.next();
        if (inputSorting.matches("[1-4]{1}")) {
            // map.entrySet() turn to list
            List<Map.Entry<String,Contact>> list = new ArrayList<Map.Entry<String,Contact>>(contacts.entrySet());
            // use comparator to sorting
            Collections.sort(list,new Comparator<Map.Entry<String, Contact>>() {
                //sorting
                public int compare(Map.Entry<String, Contact> o1,
                                   Map.Entry<String, Contact> o2) {
                    //System.out.println(inputSorting);
                    if(inputSorting.equals("1")){
                        return o1.getValue().getName().compareTo(o2.getValue().getName());
                    }else if (inputSorting.equals("2")){
                        return o1.getValue().getBirthday().compareTo(o2.getValue().getBirthday());
                    }else if (inputSorting.equals("3")){
                        return o1.getValue().getPhone().compareTo(o2.getValue().getPhone());
                    }else{
                        return o1.getValue().getEmail().compareTo(o2.getValue().getEmail());
                    }
                }

            });

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            System.out.println("Name\tBirthday\tPhone\t\tE-mail");
            System.out.println("--------------------------------------------------");

            for(Map.Entry<String,Contact> mapping : list){
                System.out.printf("%s\t%s\t%s\t%s\n", mapping.getValue().getName(),
                        sdf.format(mapping.getValue().getBirthday()), mapping.getValue().getPhone(), mapping.getValue().getEmail());
            }

        }else{
            System.out.println("Invalid input!");
        }


    }

    /**
     * Edit the Contact
     */
    public void editContacts() {
        System.out.println("Please enter the name of contact that you want to edit.");
        System.out.print("Name: ");
        String name = scanner.next();
        if(contacts.containsKey(name)){
            System.out.print("Phone: ");
            String phone = scanner.next();
            System.out.print("E-mail: ");
            String email = scanner.next();
            System.out.print("Birthday(yyyy/MM/dd): ");
            String birthdayString = scanner.next();

            // 驗證輸入格式
            if (isValidFormat(name, birthdayString, phone, email)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
                Date birthday = null; // 宣告Date物件
                try {
                    birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                    contacts.get(name).setName(name);
                    contacts.get(name).setBirthday(birthday);
                    contacts.get(name).setPhone(phone);
                    contacts.get(name).setEmail(email);
                    System.out.println("The contact has been changed.");
                } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                    e.printStackTrace(); // 顯示堆疊追蹤
                }
            }

        }else{
            System.out.println("Not found!");
        }
    }
    /**
     * Edit the Contact
     */
    public void deleteContacts(){
        System.out.println("Please enter the name of contact that you want to delete.");
        System.out.print("Name: ");
        String name = scanner.next();
        if(contacts.containsKey(name)){
            contacts.remove(name);
            System.out.println("The contact has been deleted.");
        }else{
            System.out.println("Not found!");
        }
    }

    /**
     * import the Contact
     */
    public void importContacts(){
        try{
            File file = new File("data.txt"); // fileName is the path
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = null; // read the data in a line
            StringBuilder data = new StringBuilder();   // the read data
            while ((line = br.readLine()) != null){
                //System.out.println(line);
                data.append(line + "#");    // split each line #
            }
            //System.out.println(data);
            br.close();
            fr.close();

            //write each line data to the contact Map, key is name
            String lineData[] = data.toString().split("#");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            for(int i = 0; i < lineData.length; i++){
                String contactData[] = lineData[i].split("\t");
                contacts.put(contactData[0], new Contact(contactData[0], sdf.parse(contactData[1]), contactData[2], contactData[3]));
            }
            System.out.println("All of the contacts have been imported.");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * export the Contact
     */
    public void exportContacts(){
        try {
            File file = new File("contacts.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            bw.write("Name\tBirthday\tPhone\t\tE-mail");
            bw.newLine();
            bw.write("------------------------------------------------------------");
            bw.newLine();
            for(Map.Entry<String, Contact> contact : contacts.entrySet()) {
                bw.write(contact.getValue().getName() + "\t" + sdf.format(contact.getValue().getBirthday()) + "\t" + contact.getValue().getPhone() + "\t" + contact.getValue().getEmail());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("The contact list has been exported.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除聯絡人列表
     */
    public void clearList() {
        contacts.clear(); // 移除map中的所有元素
        System.out.println("The contact list is empty.");
    }

    /**
     * 驗證輸入格式
     * @param String name
     * @param String birthday
     * @param String phone
     * @param String email
     * @return boolean
     */
    public static boolean isValidFormat(String name, String birthday, String phone, String email) {
        boolean isValidFormat = true;

        // 驗證姓名格式
        if (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid name format!");
            isValidFormat = false;
        }

        // 驗證電話號碼格式
        if (!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$")) {
            System.out.println("Invalid phone format!");
            isValidFormat = false;
        }

        // 驗證電子郵件格式
        if (!email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
            System.out.println("Invalid email format!");
            isValidFormat = false;
        }

        // 驗證出生日期格式
        if (!birthday.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$")) {
            System.out.println("Invalid date format!");
            isValidFormat = false;
        }
        
        return isValidFormat;
    }

}
