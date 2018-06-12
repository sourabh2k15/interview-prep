class Solution {
public:
    vector<int> answer;
    
    int dfs(int node, auto& edges, auto& quiet){
        if(answer[node] == -1){            
            vector<int> richer = edges[node];
            answer[node] = node;
            
            if(!richer.empty()){
                for(int richerguy : richer){                
                    int quietest_richer_guy = dfs(richerguy, edges, quiet);

                    if(quiet[quietest_richer_guy] < quiet[answer[node]]){
                        answer[node] = quietest_richer_guy;
                    }
                }
            }
        }    
        
        return answer[node];
    }
    
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        int N = quiet.size();
        answer = vector<int>(N, -1);
        
        unordered_map<int, vector<int>> edges;
        
        for(int i = 0; i < richer.size(); i++){
            int richguy = richer[i][0];
            int poorguy = richer[i][1];
            
            if(edges.count(poorguy) == 0) edges[poorguy] = vector<int>(0);
            edges[poorguy].push_back(richguy);
        }
        
        for(int i = 0; i < N; i++){  
            dfs(i, edges, quiet);
        }
        
        return answer;
    }
};
