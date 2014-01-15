//package graph;
//
//import java.util.LinkedList;
//import org.w3c.dom.Node;
//
//public class PathExistance<T> {
//
//	private enum State {
//		UNVISITED, VISITING, VISITED;
//	}
//	
//	public boolean findPath(Graph g, Node<T> start, Node<T> end) {
//		LinkedList<Node<T>> queue = new LinkedList<Node<T>>(); 
//		
//		for(Node<T> node : graph) {
//			node.state = State.UNVISITED;
//		}
//		
//		start.state = State.VISITING;
//		queue.add(start);
//		
//		while(!queue.isEmpty()) {
//			Node<T> next = queue.dequeue();			
//			if (next != null) {
//				for (Node<T> adj : g.getAdjecencyList(next)) {
//					if (adj.equals(end)) {
//						return true;
//					}
//					if(next.state == State.UNVISITED) {
//						queue.add(adj);
//						adj.state = State.VISITING;
//					}
//					adj.state = State.VISITED;
//					
//				}
//			}
//		}				
//		return false;		
// 	}	
//}
