#include <stdio.h>

void display(char *string) {
    printf("%s\n", string);
    k: printf("goto");
}
void sw(){
    int i = 1, j =2;
    switch(i){
        case 1: printf("\nswitch\n"); break;
        //Error 
        //case j: printf("switch"); break;

    }
}


void signed_char_size_for_loop(){
	signed char i  = 0;
	for(;i>=0;i++) printf("%d ",i); //0 to 127
	printf("%d ",i); //-128
	//size of is 1 byte = 2 bit
	//so 2^8 = 256 this is signed -128 0 127
}
void double_pointer(){
	int x = 10;
    int *v = &x;
    int **p = &v;
    printf("\ndouble pointer *v = &x then **p = &v printing **p %d", **p);
    
}
void pointer_checking(){
	// void pointer la void *p = &a; printf("%d", *p); error (ADDRESS MATUM THAAN PRINT PANA MUDIYUM printf("%p", p); value kediyathu)
	int a = 10;
	int *p = &a;
	p = &a;
	printf("%d ", *p);
	int* b = &a;
	printf("\nb : %d", *b);
	*b = 1;
	printf("\n%u ", *p+1);
    b = p;
}
int main() {
	
	signed_char_size_for_loop();
	
	
	pointer_checking();
	
    #define name "oli"
    char strig[] = "syed";
    display(strig);
    printf("\nname: %s\n", name);
    int s = - -2;
    printf("%d", s);
    printf("\nmain function address: %p", main);
    //return 0;

    char *po;
    po = name;
    
    if(1) goto here;
    here: printf("goto");
    printf("\n\n*&*po (&*po na address tharum) %c", *&*po);
    
    sw();
    int k =0, l =0;
    printf("\nprintf kulla scanf (scanf return value, no.of.successfull scanned) %d", printf("\n%d", printf("\n%d", scanf("\n%d %d", &k, &l))));
    int ii =0;
    for(;ii++;);
    printf("\nfor");
    
    register int x = 10;
    //register int *ptr = &x;

    printf("\nRegister keyword Value of x: %d\n", x);
    //printf("Address of x: %p\n", (void *)ptr);
	
	
	 int i =1, j =2;
    if(j=2) {
        if(printf("first if ")) printf("he");  //if la number iruntha true, aprm printf execute agum
    }
    //if(printf("")) printf("empt printf");
    //printf(); //printf("") //Empty printf error  
    
	/*
	2d array =>
				**a na
						*(*a)
								*a = a[0]+0 = a[0]		*(a+i) = a[i]
								*(*a) = *(a[0]) 
										*(a[0] + 0])
										a[0][0]
								
	*/
	
	int a[] = {2, 4, 6, 8, 10};
    int *b = a+3; //8
    printf("\n%d", *b-2); //gives the *b = 8 then 8-2
    printf("\n%d", *(b-1)); //from value 8 to 6 ,gives the (b-1) address-1, then give the value 2
    printf("\n%d %d %d %d %d %d ", b[-1],*b, b[0], b[1], b[2], b[3]);
    
	
    return 0;
}
