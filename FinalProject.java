import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class FinalRoselin {
	
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	
	Vector <String> vBookID = new Vector <> ();
	Vector <String> vBookName = new Vector <> ();
	Vector <String> vBookAuthorName = new Vector <> ();
	Vector <String> vBookGenre = new Vector <> ();
	Vector <Integer> vBookStock = new Vector <> ();
	
	Vector <String> vBorrowStudentID = new Vector <> ();
	Vector <String> vBorrowStudentName = new Vector <> ();
	Vector <String> vBorrowStudentClass = new Vector <> ();
	Vector <String> vBorrowBookID= new Vector <> ();
	Vector <String> vBorrowBookName = new Vector <> ();
	Vector <Integer> vBorrowBookStock = new Vector <> ();
	
	Vector <String> vBorrowDate = new Vector <> ();
	Vector <String> vReturnDate = new Vector <> ();
	Vector <Date> vTanggal = new Vector <> ();
	Vector <String> vBorrowStatus = new Vector <> ();
	Vector <Integer> vBorrowDenda = new Vector <> ();
	
public void enter2() {
		
		for (int i = 0; i < 2; i++) {
			System.out.println();
		}
	}

public void enter3() {
	
	for (int i = 0; i < 3; i++) {
		System.out.println();
	}
}

public void clearScreen() {
	
	for (int i = 0; i < 25; i++) {
		System.out.println();
	}
}

public String tanggal(int a) {
	Calendar cl = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
	cl.add(Calendar.DATE, a);
	Date satuMinggu = cl.getTime();
	String dateReturn = sdf.format(satuMinggu);
	return dateReturn;
}

public void addBook() {
	
	String id = "", name = "", author = "", genre = "";
	int stock = 0;
	
	int a = rand.nextInt(9);
	int b = rand.nextInt(9);
	int c = rand.nextInt(9);

	id  = "BK" + String.valueOf(a) + String.valueOf(b) + String.valueOf(c);
	
	do{
		System.out.print("Input book's name [3..20]: ");
		name = sc.nextLine();
	} while (name.length() < 3 || name.length() > 20);
	
	do {
		System.out.print("Input author's name [3...20]: ");
		author = sc.nextLine();
	} while (author.length() < 3 || author.length() > 20);
	
	do {
		System.out.print("Input book's genre [Romance | Fantasy | Drama | Action]: ");
		genre = sc.nextLine();
	} while (!genre.equalsIgnoreCase("Romance") && !genre.equalsIgnoreCase("Fantasy") && !genre.equalsIgnoreCase("Drama") && !genre.equalsIgnoreCase("Action"));
	
	do{
		System.out.print("Input book's stock: ");
		
		try {
			stock = sc.nextInt(); sc.nextLine();
		} catch (Exception e) {
			System.out.println("Input must be numeric!");
			stock = 0;
			sc.nextLine();
		}
		
	} while (stock < 1);
	
	vBookID.add(id);
	vBookName.add(name);
	vBookAuthorName.add(author);
	vBookGenre.add(genre);
	vBookStock.add(stock);
	
	System.out.println();
	System.out.println("Congratulation! The book have added!");
}

public  int compareString( String word1, String word2) {
	
	int size1 = word1.length(), size2 = word2.length();
	int minSize = 0;
	if(size1 <= size2) {
		minSize = size1;
	} else if(size1 > size2) {
		minSize = size2;
	}
	
	for (int i = 0; i < minSize; i++) {
		if(word1.charAt(i) < word2.charAt(i)) {
			return 1;
		} else if(word1.charAt(i) > word2.charAt(i)) {
			return 2;
		}
	}

	if(size1 < size2) {
		return 1;
	} else {
		return 2;
	}	
}

public void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr [i] = arr [i];
	arr [j] = temp;
}

public void sortNameBookAsc() {
	
	int result = 0;
	
	for (int i = 0; i < vBookName.size()-1; i++) {
		for (int j = 0; j < vBookName.size()-i-1; j++) {
			result = compareString(vBookName.get(j), vBookName.get(j+1));
			
			if(result == 2) {
				
				//SWAP BOOK ID
				String id1 = vBookID.get(j);
				String id2 = vBookID.get(j+1);
				String tempID = id1;
				vBookID.set(j, id2);
				vBookID.set(j+1, tempID);
				
				//SWAP BOOK NAME
				String name1 = vBookName.get(j);
				String name2 = vBookName.get(j+1);
				String tempName = name1;
				vBookName.set(j, name2);
				vBookName.set(j+1, tempName);
				
				//SWAP BOOK AUTHOR NAME
				String author1 = vBookAuthorName.get(j);
				String author2 = vBookAuthorName.get(j+1);
				String tempAuthor = author1;
				vBookAuthorName.set(j, author2);
				vBookAuthorName.set(j+1, tempAuthor);
				
				//SWAP BOOK GENRE
				String genre1 = vBookGenre.get(j);
				String genre2 = vBookGenre.get(j+1);
				String tempGenre = genre1;
				vBookGenre.set(j, genre2);
				vBookGenre.set(j+1, tempGenre);
				
				//SWAP BOOK STOCK
				int stock1 = vBookStock.get(j);
				int stock2 = vBookStock.get(j+1);
				int tempStock = stock1;
				vBookStock.set(j, stock2);
				vBookStock.set(j+1, tempStock);
			}
		}
	}
}

public void sortNameBookDesc() {
	
	int result = 0;
	
	for (int i = 0; i < vBookName.size()-1; i++) {
		for (int j = 0; j < vBookName.size()-i-1; j++) {
			result = compareString(vBookName.get(j), vBookName.get(j+1));
			
			if(result == 1) {
				
				//SWAP BOOK ID
				String id1 = vBookID.get(j);
				String id2 = vBookID.get(j+1);
				String tempID = id1;
				vBookID.set(j, id2);
				vBookID.set(j+1, tempID);
				
				//SWAP BOOK NAME
				String name1 = vBookName.get(j);
				String name2 = vBookName.get(j+1);
				String tempName = name1;
				vBookName.set(j, name2);
				vBookName.set(j+1, tempName);
				
				//SWAP BOOK AUTHOR NAME
				String author1 = vBookAuthorName.get(j);
				String author2 = vBookAuthorName.get(j+1);
				String tempAuthor = author1;
				vBookAuthorName.set(j, author2);
				vBookAuthorName.set(j+1, tempAuthor);
				
				//SWAP BOOK GENRE
				String genre1 = vBookGenre.get(j);
				String genre2 = vBookGenre.get(j+1);
				String tempGenre = genre1;
				vBookGenre.set(j, genre2);
				vBookGenre.set(j+1, tempGenre);
				
				//SWAP BOOK STOCK
				int stock1 = vBookStock.get(j);
				int stock2 = vBookStock.get(j+1);
				int tempStock = stock1;
				vBookStock.set(j, stock2);
				vBookStock.set(j+1, tempStock);
			}
		}
	}
}

public void viewBook() {
	
	int choose = 0; 

	if (vBookName.isEmpty()) {
		System.out.println("There is No Data!");
	} else {
		
		do {
			System.out.println("+====+===========+======================+====================+===========+=========+");
			System.out.println("| NO |  Book ID  |       Book Name      |  Author Book Name  |   Genre   |  Stock  |");
			System.out.println("+====+===========+======================+====================+===========+=========+");
			for (int i = 0; i < vBookName.size(); i++) {
				System.out.printf("| %-3s| %-10s| %-21s| %-19s| %-10s| %-8d|", i+1, vBookID.get(i), vBookName.get(i), vBookAuthorName.get(i), vBookGenre.get(i), vBookStock.get(i));
				System.out.println();
			}
			System.out.println("+====+===========+======================+====================+===========+=========+");
			
			System.out.println();
			System.out.println("============================");
			System.out.println("View by Sorting");
			System.out.println("----------------------------");
			System.out.println("1. Sort by Ascending");
			System.out.println("2. Sort by Descending");
			System.out.println("3. Back");
			System.out.println();
			System.out.print("Choose: ");
			
			try {
				choose = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				System.out.println("Input Must be Numeric!");
				choose = 0;
				sc.nextLine();
			}
			
			switch (choose) {
			
			case 1:
				
				enter2();
				sortNameBookAsc();
				break;
				
			case 2:
				
				enter2();
				sortNameBookDesc();
				break;
				
			default:
				break;
			}
		} while (choose !=3);
	}

	System.out.println();
	System.out.println("Press to Continue...");
	sc.nextLine();
}

public void searchBook() {
	
	String name = "";
	
	do{
		System.out.print("Input Book's Name [3..20]: ");
		name = sc.nextLine();
	} while (name.length() < 3 || name.length() > 20);
	
	for (int i = 0; i < vBookName.size(); i++) {
		if (vBookName.get(i).equalsIgnoreCase(name)) {
			System.out.println("===========================================");
			System.out.println("\t\t\tBOOK");
			System.out.println("-------------------------------------------");
			System.out.println("No\t\t: " + (i+1));
			System.out.println("Book ID\t\t: " + vBookID.get(i));
			System.out.println("Book Name\t: " + vBookName.get(i));
			System.out.println("Author Name\t: " + vBookAuthorName.get(i));
			System.out.println("Genre Book\t: " + vBookGenre.get(i));
			System.out.println("Stock Book\t: " + vBookStock.get(i));
		} else {
			System.out.println("The Book is Not Found!");
		}
	}
	
	System.out.println();
	System.out.println("Press to Continue...");
	sc.nextLine();
	
}

public void deleteBook() {
	
	int noData = -1;
	
	if (vBookName.isEmpty()) {
		System.out.println("There is No Data!");
	} else {
			System.out.println("+====+===========+======================+====================+===========+=========+");
			System.out.println("| NO |  Book ID  |       Book Name      |  Author Book Name  |   Genre   |  Stock  |");
			System.out.println("+====+===========+======================+====================+===========+=========+");
			for (int i = 0; i < vBookName.size(); i++) {
				System.out.printf("| %-3s| %-10s| %-21s| %-19s| %-10s| %-8d|", i+1, vBookID.get(i), vBookName.get(i), vBookAuthorName.get(i), vBookGenre.get(i), vBookStock.get(i));
				System.out.println();
			}
			System.out.println("+====+===========+======================+====================+===========+=========+");
	}
	
	do {
		System.out.print("Choose No Data to Delete [1.." + vBookName.size() + "]: ");
		
		try {
			noData = sc.nextInt(); sc.nextLine();
		} catch (Exception e) {
			System.out.println("Input Must be Numeric!");
			noData = -1;
			sc.nextLine();
		}
		
	} while (noData == 0 || noData > vBookName.size() + 1);
	
	if (noData == -1) {
		System.out.println("The Book is Not Found!");
	} else {
		vBookID.remove(noData-1);
		vBookName.remove(noData-1);
		vBookAuthorName.remove(noData-1);
		vBookGenre.remove(noData-1);
		vBookStock.remove(noData-1);
	}
	
	System.out.println();
	System.out.println("Congratulation! Your book have deleted!");
	System.out.println("Press to Continue...");
	sc.nextLine();
	
}

public void borrowBook() {
	
	String id = "", name = "", kelas = "", dateBorrow = "", dateReturn = "";
	int choose = -1, totalBorrow = 0;
	
	if (vBookName.isEmpty()) {
		System.out.println("There is No Book to Borrow!");
	} else {
		
		System.out.println("+====+===========+======================+====================+===========+=========+");
		System.out.println("| NO |  Book ID  |       Book Name      |  Author Book Name  |   Genre   |  Stock  |");
		System.out.println("+====+===========+======================+====================+===========+=========+");
			for (int i = 0; i < vBookName.size(); i++) {
				System.out.printf("| %-3s| %-10s| %-21s| %-19s| %-10s| %-8d|", i+1, vBookID.get(i), vBookName.get(i), vBookAuthorName.get(i), vBookGenre.get(i), vBookStock.get(i));
				System.out.println();
			}
		System.out.println("+====+===========+======================+====================+===========+=========+");
		System.out.println();
		
		do {
			System.out.print("Choose No Book to Borrow: ");
			
			try {
				choose = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				System.out.println("Input Must be Numeric!");
				choose = -1;
				sc.nextLine();
			}
			
		} while (choose == 0 || choose > vBookName.size() + 1);
		
		if (choose !=-1) {
			do {
				System.out.print("Input Total Borrow Book [1.." + vBookStock.get(choose - 1) + "]: ");
				totalBorrow =sc.nextInt(); sc.nextLine();
			} while (totalBorrow == 0 || totalBorrow > vBookStock.get(choose - 1));
			
			int a = rand.nextInt(9);
			int b = rand.nextInt(9);
			int c = rand.nextInt(9);
			
			id = "ST" + String.valueOf(a) + String.valueOf(b) + String.valueOf(c);
			
			do {
				System.out.print("Input Student's Name [3..20]: ");
				name = sc.nextLine();
			} while (name.length() < 3 || name.length() > 20);
			
			do {
				System.out.print("Input Student's Class [LI11|LJ11|LK11]: ");
				kelas = sc.nextLine();
			} while (!kelas.equals("LI11") && !kelas.equals("LJ11") && !kelas.equals("LK11"));
			
			dateBorrow = tanggal(0);
			dateReturn = tanggal(7);
			
			vBorrowStudentID.add(id);
			vBorrowStudentName.add(name);
			vBorrowStudentClass.add(kelas);
			vBorrowBookID.add(vBookID.get(choose - 1));
			vBorrowBookName.add(vBookName.get(choose - 1));
			vBorrowBookStock.add(totalBorrow);
			vBorrowDate.add(dateBorrow);
			vReturnDate.add(dateReturn);
			vBorrowStatus.add("No Returned");
			vBorrowDenda.add(0);
			
			Date tgl = new Date();
			vTanggal.add(tgl);
			
			vBookStock.set(choose - 1, vBookStock.get(choose - 1)-totalBorrow);
			
			System.out.println("=============================================================");
			System.out.println("\t\t\tBORROWING DATA");
			System.out.println("=============================================================");
			System.out.println("Date\t\t: " + dateBorrow);
			System.out.println("Student ID\t: " + id);
			System.out.println("Student Name\t: " + name);
			System.out.println("Book ID\t\t: " + vBookID.get(choose - 1));
			System.out.println("Book Name\t: " + vBookName.get(choose - 1));
			System.out.println("Total Borrow\t: " + totalBorrow);
			System.out.println("-------------------------------------------------------------");
			System.out.println("Don't forget to return your book on " + dateReturn );
			System.out.println("Thank you!");
			System.out.println("=============================================================");
			
			}
		}

	System.out.println();
	System.out.println("Press to Continue...");
	sc.nextLine();
}

public void returnBook() {
	
	String name = "", choose = "", dateReturn = "";
	int denda = 0;
	
	if (vBorrowStudentName.isEmpty()) {
		System.out.println("There is No Data!");
	} else {
		
		do {
			System.out.print("Input Student's name [3..20]:  ");
			name = sc.nextLine();
		} while (name.length() < 3 || name.length() > 20);
		
		for (int i = 0; i < vBorrowStudentName.size(); i++) {
			if (vBorrowStudentName.get(i).equalsIgnoreCase(name)) {
				
				System.out.println("=============================================================");
				System.out.println("\t\t\tBORROWING DATA");
				System.out.println("=============================================================");
				System.out.println("Date\t\t: " + vBorrowDate.get(i));
				System.out.println("Student ID\t: " + vBorrowStudentID.get(i));
				System.out.println("Student Name\t: " + vBorrowStudentName.get(i));
				System.out.println("Book ID\t\t: " + vBorrowBookID.get(i));
				System.out.println("Book Name\t: " + vBorrowBookName.get(i));
				System.out.println("Total Borrow\t: " + vBorrowBookStock.get(i));
				System.out.println("-------------------------------------------------------------");
				System.out.println("Don't forget to return your book on " + vReturnDate.get(i) );
				System.out.println("Thank you!");
				System.out.println("=============================================================");
				System.out.println();
				
				do {
					System.out.print("Choose [Returned | Cancel]: ");
					choose = sc.nextLine();
				} while (!choose.equals("Returned") && !choose.equals("Cancel"));
				
				switch (choose) {
				case "Returned":
					
					//UNTUK DENDA 
					Date tgl = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
					Date returnDate = vTanggal.get(i);
					dateReturn = sdf.format(tgl); 

					long selisihMS = Math.abs(returnDate.getTime() - tgl.getTime());
					long selisihHari = selisihMS / (24 * 60 * 60 * 1000);
					
					if (selisihHari <= 7  || selisihHari == 0) {
						denda = 0; 
					} else {
						denda = (int) selisihHari * 2000;
					}

					//UNTUK DIGANTI ISI VECTORNYA
					for (int j = 0; j < vBookName.size(); j++) {
						if (vBorrowBookName.get(i).equals(vBookName.get(j))) {
							vBookStock.set(j, vBookStock.get(j) + vBorrowBookStock.get(i));
							vReturnDate.set(i, tanggal(0));
							vBorrowStatus.set(i, "Returned");
							vBorrowDenda.set(i, denda);
						}
					}
					
					enter2();
					System.out.println("=============================================================");
					System.out.println("\t\t\tRETURNING DATA");
					System.out.println("=============================================================");
					System.out.println("Date of Borrowing\t: " + vBorrowDate.get(i));
					System.out.println("Date of Returning\t: " + vReturnDate.get(i));
					System.out.println("Student ID\t\t: " + vBorrowStudentID.get(i));
					System.out.println("Student Name\t\t: " + vBorrowStudentName.get(i));
					System.out.println("Book ID\t\t\t: " + vBorrowBookID.get(i));
					System.out.println("Book Name\t\t: " + vBorrowBookName.get(i));
					System.out.println("Total Borrow\t\t: " + vBorrowBookStock.get(i));
					System.out.println("-------------------------------------------------------------");
					System.out.println("Total Denda\t\t: " + denda);
					System.out.println("Thanks for Returning this Book!");
					System.out.println("=============================================================");
					
					break;
					
				case "Cancel":
					
					System.out.println("The Book is Canceled to Returning!");
					System.out.println("Press to Continue...");
					sc.nextLine();
					break;
					
				default:
					break;
				}

			}
		}	
	}
	
	System.out.println();
	System.out.println("Press to Continue...");
	sc.nextLine();
}

public void ledgerBorrow() {

	System.out.println("==================================================================================================================================================================================");
	System.out.println("\t\t\t\t\t\t\t\tLedger of Borrow Book");
	System.out.println("==================================================================================================================================================================================");
	System.out.println("+----+---------------------+----------------+------------------------+---------------+----------------------+--------------+-----------------+---------------------+-------------+");
	System.out.println("| No |     Borrow Date     |   Student ID   |      Student Name      |    Book ID    |      Book Name       | Total Borrow |  Borrow Status  |     Return Date     |    Denda    |");
	System.out.println("+----+---------------------+----------------+------------------------+---------------+----------------------+--------------+-----------------+---------------------+-------------+");
	
	for (int i = 0; i < vBorrowBookName.size(); i++) {
		System.out.printf("| %-3d| %-20s| %-15s| %-23s| %-14s| %-21s| %-13d| %-16s| %-20s| %-12d|", (i+1), vBorrowDate.get(i), vBorrowStudentID.get(i), vBorrowStudentName.get(i), vBorrowBookID.get(i), vBorrowBookName.get(i), vBorrowBookStock.get(i), vBorrowStatus.get(i), vReturnDate.get(i), vBorrowDenda.get(i));
		System.out.println();
	}	
	
	System.out.println("==================================================================================================================================================================================");
	System.out.println("Press to Continue...");
	sc.nextLine();
}



public FinalRoselin() throws Exception {
	int menu = 0;
	
	do{
		System.out.println("===============================");
		System.out.println("          LIBRARYGRAM             ");
		System.out.println("===============================");
		System.out.println("1. Add Book");
		System.out.println("2. View Book");
		System.out.println("3. Search Book");
		System.out.println("4. Delete Book");
		System.out.println("5. Borrow Book");
		System.out.println("6. Return Book");
		System.out.println("7. View Borrowed Book");
		System.out.println("8. Exit");
		System.out.println();
		System.out.print("Choose: ");
		
		try {
			menu = sc.nextInt(); sc.nextLine();
		} catch (Exception e) {
			System.out.println("Input must be numeric!");
			menu = 0;
			sc.nextLine();
		}
		
		switch (menu) {
		
		case 1:
			
			addBook();
			enter2();
			break;
			
		case 2:
			
			viewBook();
			enter2();
			break;
			
		case 3:
			
			searchBook();
			enter2();
			break;
			
		case 4:
			
			deleteBook();
			enter2();
			break;
			
		case 5:
			
			borrowBook();
			enter2();
			break;
			
		case 6:
			
			returnBook();
			enter2();
			break;
			
		case 7:
			
			ledgerBorrow();
			enter2();
			break;
			
		default:
			break;
		}
		
		clearScreen();
	} while (menu !=8);
		System.out.println("Thanks for using this application!");
		System.exit(0);
	
}


	
	

	public static void main(String[] args) throws Exception {
		new FinalRoselin();

	}

}
