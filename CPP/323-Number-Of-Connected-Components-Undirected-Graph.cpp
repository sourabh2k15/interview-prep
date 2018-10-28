#include <iostream>
#include <vector>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;

unordered_set<int> visited;
    
// approach 1 : recursive DFS    
void dfs(vector<vector<int>>& graph, int node){
    if(visited.find(node) != visited.end()) return;
        
    visited.insert(node);
    vector<int> neighbours = graph[node];
        
    for(int neighbour : neighbours){
        dfs(graph, neighbour);
    }
}

// approach 2 : iterative DFS
void dfs2(vector<vector<int>>& graph, int node){	
	stack<int> dfsStack;
	
	dfsStack.push(node);

	while(!dfsStack.empty()){
		int currentNode = dfsStack.top(); dfsStack.pop();
		visited.insert(currentNode);

		vector<int> neighbours = graph[currentNode];
		
		for(int neighbour : neighbours){
			if(visited.find(neighbour) == visited.end()) dfsStack.push(neighbour);
		}
	}
}

void bfs(vector<vector<int>>& graph, int node){
	queue<int> bfsQueue;

	bfsQueue.push(node);

	while(!bfsQueue.empty()){
		int currentNode = bfsQueue.front(); bfsQueue.pop();
		visited.insert(currentNode);

		vector<int> neighbours = graph[currentNode];

		for(int i = 0; i < neighbours.size(); i++){
			if(visited.find(neighbours[i]) == visited.end()) bfsQueue.push(neighbours[i]);
		}
	}
}

int countComponents(int n, vector<pair<int, int>>& edges) {
    vector<vector<int> > graph(n, vector<int>());
    
    for(pair<int, int>& edge : edges){
        graph[edge.first].push_back(edge.second);
        graph[edge.second].push_back(edge.first);
    }
    
    int components = 0;
    
    for(int i = 0; i < n; i++){
        if(visited.find(i) == visited.end()){
        	components++;
            bfs(graph, i);
        }
    }
    
    return components;
}

int find(vector<int>& parent, int node){
	if(parent[node] == -1) return node;
	return find(parent, parent[node]);
}

int countComponents2(int n, vector<pair<int, int>>& edges){
	vector<int> parent(n, -1);
	int components = n;

	for(pair<int, int>& edge : edges){
		int a = edge.first;
		int b = edge.second;

		int parentA = find(parent, a);
		int parentB = find(parent, b);

		if(parent[parentA] == -1) components--;
		parent[parentA] = parentB;
	}

	return components;
}

// driver method
int main(){
	int n = 10;

	vector<pair<int, int> > edges = {
										{0, 2},
										{2, 3},
										{1, 4},
										{5, 6},
										{2, 6},
										{7, 8},
										{8, 9},
										{0, 9}
									};

	cout << countComponents2(n, edges) << endl;
}