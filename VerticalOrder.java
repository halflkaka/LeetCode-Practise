/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        
        if (root == NULL) {
            vector<vector<int>> res;
            return res;
        }
        
        map<TreeNode*, int> index;
        
        int* range = new int[2];
        *range = 0;
        *(range+1) = 0;
        getRange(root, range, 0);
        
        int length = range[1] - range[0] + 1;
        vector<vector<int>> ans(length);
        
        queue<TreeNode*> q;
        q.push(root);
        
        int posOfRoot = -range[0];
        index[root] = posOfRoot;
        
        while (q.size() > 0) {
            int size = q.size();
            // cout << size << endl;
            
            for (int i = 0; i < size; i++) {
                TreeNode* cur = q.front();
                q.pop();

                int pos = index[cur];
                
                vector<int> col = ans[pos];
                col.push_back(cur->val);
                // cout << cur -> val << endl;
                ans[pos] = col;
                
                if (cur -> left != NULL) {
                    q.push(cur->left);
                    index[cur->left] = pos - 1;
                }
                if (cur -> right != NULL) {
                    q.push(cur->right);
                    index[cur->right] = pos + 1;
                }
            }
        }
        
        return ans;
        
    }
    
    void getRange(TreeNode* root, int* range, int col) {
        if (root == NULL) {
            return;
        }
        *range = std::min(*range, col);
        *(range+1) = std::max(*(range+1), col);

        getRange(root->left, range, col - 1);
        getRange(root->right, range, col + 1);
    }
};