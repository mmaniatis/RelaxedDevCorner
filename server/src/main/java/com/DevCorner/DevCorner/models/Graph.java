package com.DevCorner.DevCorner.models;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public LinkedList<Integer> adj[];
    public int size;

    public Graph(int v)
    {
        size = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }


    public void buildGraph(List<List<Integer>> connections)
    {
        for (int i = 0; i < connections.size(); i++)
        {
            this.addEdge(connections.get(i).get(0), connections.get(i).get(1));
        }
    }
}
