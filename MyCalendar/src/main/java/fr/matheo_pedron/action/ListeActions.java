package fr.matheo_pedron.action;

import java.util.LinkedList;
import java.util.List;

public class ListeActions<T> {
	private LinkedList<Action<T>> listeActions;

	public ListeActions(List<Action<T>> listeActions) {
		this.listeActions = new LinkedList<>(listeActions);
	}

	public Action<T> get(int index) {
		return listeActions.get(index);
	}

	public int size() {
		return listeActions.size();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < listeActions.size(); i++) {
			res.append((i + 1)).append(" - ").append(listeActions.get(i).description()).append("\n");
		}
		return res.toString();
	}
}
