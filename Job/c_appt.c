#include<stdio.h>
#include<string.h>
void sizearray(int *a){
	printf("size of array passing to argument gives only %d but it has 3 elements", sizeof(a));
}
void apt1(){
	int x = 130;
	char *p;
	p = (char *)&x;	  // char -128 0 127
	printf("%d\n", *p); //-126
}
void apt2(){
	int x = 130;
	int *a;
	int **p;
	a = &x;
	p = &a;
	//p++; if this line added gives  runtime error
	printf("%d\n", *p);
	printf("%d\n", **p); 
}

void apt3(){
	char *ptr = "syed";
	char b[] = "masood";
	char *ptr1 = b;
	char a[22];
	strcpy(a, "m"); //strcpy(a, ptr);
	printf("%s %s %c", ptr, a, *ptr); //no need of giving *, it prints result
	//*(ptr+1) = 'c';
	while (*ptr != '\0') {
        printf("%c ", *ptr);
        ptr++; // Move the pointer to the next character
    }
	for(int i =0;*ptr1!='\0';ptr1++) printf("%c ", *ptr1);
}
void apt4(){
    char str[] = "syed"; // Create an array of characters
    char *ptr = str;     // Initialize a pointer to the array

    // Modify the second character in the array
    *(ptr + 1) = 'c';

    // Print the modified string
    printf("%s\n", str);
}
void apt5(){
	printf("%d\n",printf("%s ", "hello"));
	// while(printf("%d", 5) <4) printf("loop ");
	// infinite loop 5loop 5loop ...	
}
void apt6(){
	int a[] = {1,2,3};
	printf("original size = %d ", sizeof(a));
	sizearray(a);
}
int main(){
	apt1();
	apt2();
	apt3();
	apt4();
	apt5();
	apt6();
	return 0;
}