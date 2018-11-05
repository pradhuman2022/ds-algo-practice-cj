class Graph {
    int [] vertices;
    int maxVerticesCount;
    int verticesCount;

    int [][] adjMatrix;

    Graph(int vertices) {
        this.maxVerticesCount = vertices;
        this.verticesCount = 0;
        this.vertices = new int[maxVerticesCount];
        this.adjMatrix = new int[maxVerticesCount][maxVerticesCount];
    }

    void addVertex(int v) {
        this.vertices[verticesCount++] = v;
    }

    void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = weight;
        }
    }

    void removeEdge(int u, int v) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = 0;
        }
    }

    void showAdjMatrix() {
        for (int i = 0; i < maxVerticesCount; i++) {
            for (int j = 0; j < maxVerticesCount; j++) {
                System.out.print(String.format("%10s", adjMatrix[i][j]));
            }
            System.out.println();
        }
    }

    /*
        (0) --5--> (1)
                  / |
                /   1
               7    |
             /      |
           /        |
          v         v
        (2) --2--> (3)
    */
    public static void main(String [] args) {
        Graph graph = new Graph(4);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 2, 7);

        graph.showAdjMatrix();
    }
}


