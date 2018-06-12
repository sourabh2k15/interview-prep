class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length() <= 1) return s.length();
        unordered_set<char> history;
        
        int start = 0, end = 0, len = 0;
        
        while(end < s.length()){
            //cout << start << " " << end << endl;
            
            if(history.find(s[end]) == history.end()){
                history.insert(s[end]);
                end++;
            }
            else{
                if(len < end - start){
                    len = end - start;
                }
                
                while(history.find(s[end]) != history.end()){
                    history.erase(s[start++]);
                }
            }
        }
        
        len = max(len, end - start);
        
        return len;
    }
};
