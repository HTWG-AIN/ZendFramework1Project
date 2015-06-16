
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*argc is the count of argument. argv is short for argument variable. It will contain all arguments passed on the command line. argv[1] contains the first argument so atoi(argv[1]) will convert the first argument to an int
*/

int main(int argc, char *argv[])
{

    int n , i; /* n = Groeße des Feldes */
    int *zahl;
    srand((unsigned int) time(NULL));


    if(argc != 2) /* must be at least 1 ; number of chars */
    {
        printf("nicht genuegend Parameter");
        exit(1);
    }
    n = atoi(argv[1]);/*[0] ist der Name des Programmes [1] erstes Parameter*/
    zahl = (int *) calloc(n, sizeof(int));
    /* ueberall nullen
       ODER *zahl = (int *) malloc(size * sizeof(int));
       */
      printf("Bitte geben Sie %d ganze Zahlen ein:\n", n);
        for(i=0; i < n; i++){
            scanf("%d", &zahl[i]);
        }
    
  /*  for(i = 0; i < n; i++)
    {
        printf("%d \n", zahl[i] = rand() );

    }
    */
    for (i = n; i > 1; i--)
    {

        int j;
        for (j = 0; j < i - 1; ++j)
        {
            if (zahl[j] > zahl[j + 1])
            {
                int tmp = zahl[j + 1];
                zahl[j + 1] = zahl[j];
                zahl[j] = tmp;
            }
        }
    }

    printf("sortieren : \n " );
    for(i = 0; i < n; i++)
    {
        printf("%d\n", zahl[i]);
        printf("\n");
    }

    return 0;
}
