package lesson7.homework;

import lesson7.classwork.Graph;

public class Homework7 {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        fillIn(graph);

//        graph.bfs("Москва"); // test
//        graph.dfs("Москва"); // test

//        graph.findShortestPath("Москва", "Воронеж");
        graph.findShortestPath("Тула", "Курск");
    }

    private static void fillIn(Graph graph) {
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
    }
}
