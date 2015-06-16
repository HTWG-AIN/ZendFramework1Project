
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "fachnote.h"





int einlesen(fach_note *n)   /*kann auch int* sein  ? */
{

    char *pos;

    if (scanf("%20s", n->fachname) == 1)
    {
         pos = strchr(n->fachname, '_'); /*ab dem Zeichen; also alles davor ist weg */
        /*  for( pos = 0; pos < n->fachname; pos++)
            {}
        */
        while (pos != NULL)
        {
            *pos = ' ';
            pos = strchr(pos++, '_'); /*ab dem Zeichen; also alles davor ist weg */


        }
    
        if (scanf("%d", &(n->u.note)) == 1) 		/* oder (*n).fachname  */
        {
            n->art = BENOTET;   /* Beurteilung ist B oder N*/
            return 1;

        }
        else if (scanf("%c", &(n->u.beurteilung)) == 1)
        {

            n->art = UNBENOTET;
            return 1;
        }
        else
        {
            return 0;
        }

    } else {
        return 0;
    }
   
}


void ausgeben(const fach_note *n)
{
    /*n = (fach_note *) malloc(sizeof(fach_note));
    */
    if (n->art == BENOTET)
    {
        switch(n->u.note)
        {
        case 10:
        case 13:
        case 17:
        case 20:
        case 23:
        case 27:
        case 30:
        case 33:
        case 37:
        case 40:
        case 50:
            printf("%-20s %d,%d\n", n->fachname, n->u.note / 10, n->u.note % 10);
            break;
        default :

            printf("%-20s Fehler : %d\n", n->fachname, n->u.note );
            break;
        }
    }
    else
    {
        switch(n->u.beurteilung)
        {
        case 'B':
            printf("%-20s %s\n" , n->fachname , "bestanden");
            break;
        case 'N':
            printf("%-20s %s\n" , n->fachname, "nicht bestanden");
            break;

        default :

            printf("%-20s Fehler : %c\n", n->fachname, n->u.beurteilung );
            break;
        }
    }
    return;

}

