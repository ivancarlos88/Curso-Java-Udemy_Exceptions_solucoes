package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter room number: ");
		int number = ler.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(ler.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(ler.next());
		
		if(! checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check Out date must be after Check In date");
			
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update reservation:");
			
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(ler.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(ler.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation dates to update must be future");
			}else if(! checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check Out date must be after Check In date");
				
			}else {
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			}
		}
		
		
	}

}
