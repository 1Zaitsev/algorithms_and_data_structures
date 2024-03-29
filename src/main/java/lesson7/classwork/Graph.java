package lesson7.classwork;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean [][] adjMat;

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public void addVertex(String label){
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void addEdge(String startLabel, String finishLabel){
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if(startIndex == -1 || finishIndex == -1)
            throw new IllegalArgumentException("Invalid vertex labels.");

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    public void addEdges(String startLabel, String secondLabel, String ... others){
        addEdge(startLabel, secondLabel);
        for(String anotherLabel: others){
            addEdge(startLabel, anotherLabel);
        }
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {

            if(vertexList.get(i).getLabel().equals(label)){
                return i;
            }
        }

        return -1;
    }

    public void display(){
        System.out.println("__________________");
        System.out.println("Graph size is " + getSize());
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if(adjMat[i][j]){
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
        System.out.println("__________________");
    }

    public void bfs(String startLabel){
        int startIndex = indexOf(startLabel);
        if (startIndex == -1)
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()){
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex != null){
                visitVertex(queue, vertex);
            }else
                queue.remove();

        }

        resetVertexState();
    }

    public void findShortestPath(String startLabel, String finishLabel){
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if(startIndex == -1)
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        if(finishIndex == -1)
            throw new IllegalArgumentException("Invalid finishLabel: " + finishLabel);

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()){
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex == null) {
                queue.remove();
            }
            else{
                visitVertex(queue,vertex);
                vertex.setPrevious(queue.peek());
                if(vertex.getLabel().equals(finishLabel)){
                    Stack <String> path = new Stack<>();
                    StringBuilder pathToString = new StringBuilder();
                    while(vertex!=null){
                        path.push(vertex.getLabel());
                        vertex = vertex.getPrevious();
                    }
                    while (!path.isEmpty()){
                        pathToString.append(path.pop() + " ");
                    }

                    System.out.println(pathToString);

                }
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);

        }
    }


    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
//        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1)
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()){
            vertex = getNearUnvisitedVertex(stack.peek());
            if(vertex != null){
                visitVertex(stack, vertex);
            }else
                stack.pop();
        }

        resetVertexState();
    }

    public void dfsRec(String startLabel){
        int startIndex = indexOf(startLabel);
        if (startIndex == -1)
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);

        Vertex vertex = vertexList.get(startIndex);

        dfsRec(vertex);

        resetVertexState();
    }

    private void dfsRec(Vertex vertex){
        if(vertex == null)
            return;

        System.out.println(vertex.getLabel());
        vertex.setVisited(true);

        Vertex current = vertex;
        while(current!=null) {
            current = getNearUnvisitedVertex(vertex);
            dfsRec(current);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex currentVertex) {
        int currentIndex = vertexList.indexOf(currentVertex);
        for (int i = 0; i < size; i++) {
            if(adjMat[currentIndex][i] && !vertexList.get(i).getVisited()){
                return vertexList.get(i);
            }
        }
        return null;
    }
}
