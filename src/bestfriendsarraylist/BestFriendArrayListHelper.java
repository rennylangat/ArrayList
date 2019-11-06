/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestfriendsarraylist;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class BestFriendArrayListHelper {

BestFriend [] myBffs = new BestFriend[10]; //global array

Scanner keyboard = new Scanner(System.in); //global scanner

String firstName;

String lastName;

String nickName;

String cellPhone;

String email;

String newLastName;

String newFirstName;

String newNickName;

int currentSize = 0;

public void addAFriend()

{

System.out.print("What is the first name of your friend?");

firstName = keyboard.nextLine();

System.out.print("What is the last name of your friend?");

lastName = keyboard.nextLine();

System.out.print("What is your friend's nickname?");

nickName = keyboard.nextLine();

System.out.print("What is your friend's cellphone number?");

cellPhone = keyboard.nextLine();

System.out.print("What is your friend's email?");

email = keyboard.nextLine();

if (firstName.isEmpty() || lastName.isEmpty() || cellPhone.isEmpty()) // error message appears if these 3 fields are missing

{

System.out.println("Unable to add your friend, missing required data (first, last, cellphone)");

}

else

{

BestFriend myFriend = new BestFriend(firstName, lastName, nickName, cellPhone, email);

{

if(myBffs[currentSize] != myFriend )

{

myBffs[currentSize] = myFriend;

System.out.println("Friend was succesfully added!" + myFriend);

}

currentSize++;

}

}

}

public void display() // prints a specfic friend or all friends

{

System.out.println("a. Display a specific friend");

System.out.println("b. Display all friends");

String displayOption = keyboard.nextLine(); // stores user's answer

if (displayOption.equalsIgnoreCase("a"))

{

System.out.println("What is your friends first name?");

firstName = keyboard.nextLine();

System.out.println("What is your friends last name?");

lastName = keyboard.nextLine();

System.out.println("What is your friends nickname?");

nickName = keyboard.nextLine();

int index = searchAFriend(firstName, lastName, nickName);

if(index == -1) // not found

{

System.out.println("Sorry, your friend cant be found" ); //error message

}

else

{

System.out.println(myBffs[index]);

}

}

else

{

for (BestFriend BF : myBffs) //data type and name of object : name of array list

{

System.out.println(BF);

}

}

}

public int searchAFriend(String firstName, String lastName, String nickName)

{

BestFriend searchFriend = new BestFriend(firstName, lastName, nickName); // new bestfriend object

int index = -1;

do

{

index++;

} while (index < myBffs.length && (!searchFriend.equals(myBffs[index])));

if (index >= myBffs.length)

{

return -1; // friend not found

}

else

{

return index;

}

}

public void changeFriend()

{

int index = searchAFriend(firstName, lastName, nickName);

System.out.println("Enter first name of friend you'd like to change");

firstName = keyboard.nextLine();

System.out.println("Enter the last name of friend you'd like to change");

lastName = keyboard.nextLine();

System.out.println("Enter the nickname of friend you'd like to change");

nickName = keyboard.nextLine();

BestFriend chgBFF = new BestFriend(firstName, lastName, nickName);

if (myBffs[index] == chgBFF) //if arraylist contains new friend object

{

System.out.println("Please enter new first name");

newFirstName = keyboard.nextLine();

System.out.println("Please enter new last name");

newLastName = keyboard.nextLine();

System.out.println("Please enter new nickname");

newNickName = keyboard.nextLine();

chgBFF.setLastName(newLastName);

chgBFF.setFirstName(newFirstName); // new first/last/nickname is set back into arrayList

chgBFF.setNickName(newNickName);

myBffs[index] = chgBFF;

}

else

{

System.out.println("Friend does not exist"); // error message if array list does not contain new friend object

}

}

public void removeFriend(){

String first;

String last;

String nickName;

System.out.println("Enter first name you wish to remove");

first = keyboard.nextLine();

System.out.println("Enter last name you wish to remove");

last = keyboard.nextLine();

System.out.println("Enter nickname you wish to remove");

nickName = keyboard.nextLine();

BestFriend removeBFF = new BestFriend(first, last, nickName);

if (myBffs.contains(removeBFF))

{
    myBffs.remove(0); // gets the index of object that user wants to remove
    
    System.out.println("Friend was succesfully removed!");
}

else {
    
    if (!myBffs.contains(removeBFF))
        
    {
        
        System.out.println("Friend does not exist");
        
    }
    
}

}

}
