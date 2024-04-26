#include<stdio.h>
#include<stdlib.h>
void pointer(){
	printf("pointer\n");
	int a = 10;
	int *p = &a; 
	//p = &a; valid
	//int *p; *p = &a; invalid;
	int* p1 = &a;
	
	void *p2;
	p2 = &a; //p &p a
	printf("\nvoid pointer: %d\nwe cannot derefernce void pointer\n", p2);
	//we cannot derefernce void pointer
	
	printf("\na:   %d \n*p:  %d \n*p1: %d", *p, a, *p1);
	printf("\n\nAddress of a: %d\nAddress of p(pointer): %d", &a, &p);
	printf("\nvalue inside the *p:  %d", p);
	int **q = &p;
	printf("\n\n(Double pointer) Address of q: %d", &q);
	printf("\nvalue inside the pointer **q:  %d", *q);
	printf("\nvalue inside the pointer **q denotes: %d", *(*q));
	printf("\n%d ", *(*q));
	printf("\n-----------------------\n");
	
}
void pointer_array(int a[], int size){ //int a[] == int *a;
	printf("\npointer_array\n");
	int n = sizeof(a)/sizeof(a[0]);
	printf("\narraysize : %d, sizeof a = %d, sizeof a[0] = %d\n", n, sizeof(a), sizeof(a[0]));
	for(int i =0; i< size;i++) a[i] = a[i]*2; //*(a+i)*2
	
}
void character_array(){
	printf("\ncharacter_array\n");
	char a[20] = "hello";
	//a = "syed"; invalid
	char b[] = "syed";
	char c[] = {'s','y','e','d','\0'};
	//arrays and pointer are differnt types that are used in similar manner
	
	char *a1 = a;
	printf("\nchar *a1 = a; -> a1[1]: %c\n", a1[1]);
	
	printf("\nDerefreneing *a1: ");
	while(*a1 != '\0'){
		printf("%c", *a1); a1++;
	}
	printf("\n%c", a);
	
}
void d2_pointer(){
	printf("\n2D Array Pointer\n\n");
	int a[2][3] = {{2,3,6},{4,5,8}};
	
	int (*p)[3] = a;
	//invalid int *p =a; int *p[3] = a;
	printf("Address of a  : %d %d %d %d %d %d %d %d",a, &a, &a[0], *a, &a[0][0],a[0][0], *a[0], **a);
	printf("\nAddress of a+1: %d %d %d %d %d %d %d", a+1, &a[1], a[1], *(a+1), &a[1][0], a[1][0], *a[1]);
	printf("\n%d %d",*(a+1)+2, *(*(a+1)+2)); //A 8
	printf("\n%d %d", *(a[0]+1), *(*(a)+2)); //3 6
	printf("\n-----------------------\n");
	
}
void multidimensional_array_pointer(){
	printf("multidimensional_array_pointer\n");
	int c[3][2][2] = {{{2,5}, {7,9}},
					  {{3,4}, {6,1}},
					  {{0,8}, {11,13}}};
	printf("\n%d %d %d %d %d",c, *c, c[0], c[0][0], &c[0], &c[0][0] );
	printf("\n%d", *(c[0][1]+1)); 
	
	printf("\n\nPassing array as argument\n");
	printf("1D array A[] => func(A) ==> func(int *a) or func(int A[])\n");
	printf("2D array A[3][2] => funct(A) ==> func(int (*a)[2]) or func(int a[][2])\n");
	printf("3D array A[3][2][2] => func(A) ==> func(int (*a)[2][2]) or func(int a[][2][2])\n");
	printf("\n-----------------------\n");
}
void dynamic_memory(){
	printf("\ndynamic memory\n\n");
	int a = 10; //stack
	printf("a variable in stack: %d", a);
	int *p;
	p = (int*)malloc(sizeof(int));
	p = &a;
	//2.28 time
	printf("\npointer *p assign memory on heap through malloc if we didn't free it, it will be on the memory\n\nA(p, &a)\n%d %d\n\nV(*p, a)\n%d %d",p, &a, *p, a);
	printf("\n\nin c++\n");
	printf("new, delete");
	/*
		int a;
		int *p;
		p = new int;
		*p = 10;
		delete p;
		p = new int[20];
		delete[] p;
	*/
	printf("\n-----------------------\n");
}
void dynamic_memory1(){
	
}
int sumofNum(int a, int b){
	//call by value
	a+=2;
	b+=2;
	int c = a+b;
	return c;
}
int sumofNumR(int *i, int *j){
	//call by refernce
	*i = *i+2; 
	*j = *j+2;
	int c = (*i) + (*j);
	return c;
}
int *sumofNumP(int *i, int *j){
	int c = (*i) + (*j);
	//return &c; 
	
	int *a = (int*)malloc(sizeof(int));
	*a = (*i) + (*j);
	return a;
}
void pointer_as_return(){
	printf("\npointer_as_function_return\n");
	int a = 2, b = 3;
	printf("\na: %d b: %d\n", a, b);
	int c = sumofNum(a, b);
	printf("\ncall-by-value a: %d b: %d c:%d\n", a, b, c);
	int ref = sumofNumR(&a, &b);
	printf("\ncall-by-reference(changing the V a,b)\na: %d b: %d ref: %d\n", a, b , ref);
	int* ptr = sumofNumP(&a, &b);
	printf("\nreturn of function pointer %d", *ptr); 
	//give error time(2.53.41)
}

void bitwiseor(){
	printf("\nBitwise OR");
	int a = 4, b  = 3;
	a = a^b;
	b = a^b;
	a = a^b;
	printf("\n%d %d",a,b);
}
int main(){
	
	/*
		1. pointer
		2. passing argument - call by value, call by reference
		3. array pointer 
		4. passing array as argument
		5. character array and pointer
		6. pointers and multidimensional arrays & passing array as argument
		7. dynamic_memory Heap malloc, realloc, calloc, free (in c++ new, delete)
		8. malloc, realloc, calloc, free (pakanum)
		9. pointer as function return
		10. function pointers
	*/
	
	pointer();
	int a[] = {1,2,3,4};
	pointer_array(&a[0], sizeof(a)/sizeof(a[0]));
	//return 1, 4, 4 because passing array as argument, compiler interpet as pointer (int *a) 	 time:1.14.12
	//a can be also passed &a[0]
	for(int i =0;i<4;i++) printf("%d ", *(a+i)); // 2 4 6 8, doubles from pointer_array func
	printf("\n-----------------------\n");
	character_array();
	printf("\n-----------------------\n");
	d2_pointer(); 
	multidimensional_array_pointer();
	dynamic_memory();
	dynamic_memory1();
	pointer_as_return();
	bitwiseor();
	return 0;
}