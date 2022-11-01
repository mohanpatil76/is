#include<bits/stdc++.h>

using namespace std;

int main() {
    vector<vector<char>> v(26 , vector<char>(26));
    for (int i = 0; i < 26; ++i)
    {
        v[0][i] = 'a' + i;
    }
    for (int i = 1; i < 26; ++i)
    {
        v[i] = v[i-1];
        rotate(v[i].begin(), v[i].begin()+1, v[i].end());
    }
    string plainText = "";
    string key = "";
    string encryptText = "";
    cout<<"Enter Text"<<" ";
    cin>>plainText;
    cout<<"Enter Key"<<" ";
    cin>>key;
    for(int i = 0 ; i < plainText.length() ; i++){
        encryptText += v[key[i%key.length()]-'a'][plainText[i]-'a'];
    }
    cout<<"Encrypt Text "<<encryptText<<endl;
    string decryptText = "";
    for (int i = 0; i < encryptText.length(); ++i)
    {
        int idx = 0;
        while(v[key[i%key.length()]][idx] != encryptText[i]) idx++;
        decryptText += 'a' + idx;
    }
    cout<<"Decrpt Text "<<decryptText<<endl;
    return 0;
}