#include<mpi.h>
#include<stdio.h> 
#include<stdlib.h>

void allocate(int a[],int n) {
	for(int i = 0; i < n;i++)
	a[i] = rand()%1001;
}

int main(int argc,char *argv[]) {
	int rank,size,n,sum = 0,count,*a=NULL;
	int max = -1, min = 1001;
	rand();
	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	MPI_Comm_rank(MPI_COMM_WORLD,&rank);
	n = atoi(argv[1]);
	count = n/size;

	if(rank==0) {
		a = (int *)malloc(n*sizeof(int));
		allocate(a,n);
	}

	for(int i = 0; i < count;i++) {
		printf("\t%d",a[i]);
		if(a[i] > max)
			max = a[i];
		if(a[i] < min)
			min = a[i];
	}

	printf("\nmax = %d\t min = %d",max,min);
	MPI_Finalize();
}

// mpicc Q2.c -o Q2
// mpirun -np 1 ./Q1 100

