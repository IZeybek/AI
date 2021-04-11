package puzzle8;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Klasse Board für 8-Puzzle-Problem
 * @author Ihr Name
 */
public class Board {

	/**
	 * Problmegröße
	 */
	public static final int N = 8;

	/**
	 * Board als Feld. 
	 * Gefüllt mit einer Permutation von 0,1,2, ..., 8.
	 * 0 bedeutet leeres Feld.
	 */
	protected int[] board = new int[N+1];

	/**
	 * Generiert ein zufälliges Board.
	 */
	public Board() {
	}
	
	/**
	 * Generiert ein Board und initialisiert es mit board.
	 * @param board Feld gefüllt mit einer Permutation von 0,1,2, ..., 8.
	 */
	public Board(int[] board) {
		
	}

	@Override
	public String toString() {
		return "Puzzle{" + "board=" + Arrays.toString(board) + '}';
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Board other = (Board) obj;
		return Arrays.equals(this.board, other.board);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Arrays.hashCode(this.board);
		return hash;
	}
	
	/**
	 * Paritätsprüfung.
	 * @return Parität.
	 */
	public boolean parity() {
		int count_wrong_pairs = 0;

		for (int pos_x = 0; pos_x < board.length; pos_x++) {
			if (board[pos_x] == 0) {
				continue;
			}
			for (int pos_y = 0; pos_y < pos_x; pos_y++) {
				if (board[pos_y] == 0) {
					continue;
				}
				if (board[pos_y] > board[pos_x])
					count_wrong_pairs++;
			}
		}
		return count_wrong_pairs % 2 == 0;
	}
	/**
	 * Heurstik h1. (siehe Aufgabenstellung)
	 * @return Heuristikwert.
	 */
	public int h1() {
		int count_wrong_fields = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				continue;
			}
			if (i != board[i]) {
				count_wrong_fields++;
			}
		}
		return count_wrong_fields;
	}
	
	/**
	 * Heurstik h2. (siehe Aufgabenstellung)
	 * @return Heuristikwert.
	 */
	public int h2() {
		int summe_manhattan_distance = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				continue;
			}
			int destination_column = i % 3;
			int destination_row = i / 3;

			int current_column = board[i] % 3;
			int current_row = board[i] / 3;

			summe_manhattan_distance += Math.abs(destination_column - current_column) +
					Math.abs(destination_row - current_row);
		}
		return summe_manhattan_distance;
	}
	
	/**
	 * Liefert eine Liste der möglichen Aktion als Liste von Folge-Boards zurück.
	 * @return Folge-Boards.
	 */
	public List<Board> possibleActions() {
		List<Board> boardList = new LinkedList<>();
		// ...
		return boardList;
	}
	
	
	/**
	 * Prüft, ob das Board ein Zielzustand ist.
	 * @return true, falls Board Ziestzustand (d.h. 0,1,2,3,4,5,6,7,8)
	 */
	public boolean isSolved() {
		return true;
	}
	
	
	public static void main(String[] args) {
		Board b = new Board(new int[]{7,2,4,5,0,6,8,3,1});		// abc aus Aufgabenblatt
		Board goal = new Board(new int[]{0,1,2,3,4,5,6,7,8});
				
		System.out.println(b);
		System.out.println(b.parity());
		System.out.println(b.h1());
		System.out.println(b.h2());
		
		for (Board child : b.possibleActions())
			System.out.println(child);
		
		System.out.println(goal.isSolved());
	}
}
	
