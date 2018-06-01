#include <iostream>

using namespace std;

bool ifAdjacent(string a, string b){
    int count = 0;
    
    for(int i = 0; i < a.length(); i++){
        if(a[i] != b[i]) count++;
        if(count > 1) return false;
    }
    
    return true;
}

vector<string> findPath(string start, string end, auto dict){
    queue<string> q;
    vector<string> path;
    unordered_map<string, string> parents;
    
    q.push(start);
    
    while(!q.empty()){
        string current = q.front(); q.pop();
        //cout << current << endl;
        
        for(auto it = dict.begin(); it != dict.end(); ++it){            
            string word = *it;
            //cout << " s " << word << " " << endl;
            
            if(ifAdjacent(word, current)){
                parents[word] = current;
                if(word == end) break;
                q.push(word);
                
                //cout << "deleted " << word << endl;
                dict.erase(word);
            }
        }
    }
    
    string goal = end;
    path.push_back(end);
    
    while(goal != start){
        string parent = parents[goal];
        path.push_back(parent);
        
        goal = parent;    
    }
    
    return path;
}

int main() {
    set<string> dict = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
    string start = "TOON";
    string end = "PLEA";
    
    vector<string> path = findPath(start, end, dict);
    
    for(string s : path){
        cout << s << " ";
    }
    
    cout << endl;
    return 0;
}
