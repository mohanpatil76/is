#include <iostream>
#include <cmath> 
using namespace std;
 
// IS Exp6- Implementation of Diffie Hellman Key Exchange Algorithm
 
long long int power(long long int a, long long int b,long long int P)
{
if (b == 1) return a; else
return (((long long int)pow(a, b)) % P);
}
int main()
{
long long int P, G, x, a, y, b, ka, kb; cout << "The value of P : ";
cin>>P;
cout << "The value of G : " ; cin>>G;
cout << "The private key a for Alice : "; cin>>a;
x = power(G, a, P);
cout << "The private key b for Bob : "; cin>>b;
y = power(G, b, P);
ka = power(y, a, P);
kb = power(x, b, P);
cout << "Secret key for the Alice is : " << ka << endl; cout << "Secret key for the Bob is : " << kb << endl; return 0;
}
