package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
		Actor actor = db.findActorById(1);
		System.out.println(actor);
		List<Actor> actors = db.findActorsByFilmId(1);
		System.out.println(actors);
		System.out.println(film.getActors());
	}

	private void launch() {
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;
		while(keepGoing) {
			
			printMenu();
			String userChoice = getUserChoice();
			keepGoing = userInterfaceChoice(userChoice);
		}
	}

	private boolean userInterfaceChoice(String choice) {
		switch (choice) {
		case "1":
			System.out.println("Enter the film's ID: ");
			int filmId = input.nextInt();
			Film film = db.findFilmById(filmId);

			if (film != null) {
				System.out.println(film.getFilmTitle());
				System.out.println(film.getReleaseYear());
				System.out.println(film.getFilmRating());
				System.out.println(film.getFilmDesc());
				System.out.println();
			} else {
				System.out.println("No such film exists. Perhaps begin production yourself..?");
			}
			break;
			
		case "2":
			System.out.println("Enter the film's keyword: ");
			String filmKeyword = input.next();
			db.findFilmByKeyword(filmKeyword);
			break;
			
		case "3":
			System.out.println("Thanks for caring about film! Tiktok sucks!");
			return false;
				
		default: {
			System.out.println("Invalid entry. Please try again. ");
			break;
		}
		}
		return true;
	}

	private void printMenu() {
		System.out.println("******** Film Inventory ********");
		System.out.println("1. Find films by ID: ");
		System.out.println("2. Find films by keyword: ");
		System.out.println("3. Exit");

	}
	private String getUserChoice() {
		String choice = input.nextLine();
		return choice;
	}
	
	
}

// TODO act on choice
// TODO repeat till quit
