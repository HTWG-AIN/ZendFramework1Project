
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "liste.h"


fach_note *einfuegen(fach_note *head, fach_note *neues, fach_note **removed)
{
    fach_note *p;
    *removed = NULL;
    
    if(head == NULL){
        neues->nach = NULL;
        neues->vor = NULL;
        return neues;
    }
    for (p=head ; p != NULL; p = p->nach)
    {
        if (!strcmp(p->fachname,  neues->fachname) )
        {
                *removed = p;
                if(p->nach != NULL)
                {
                    p->nach->vor = p->vor;
                }
                if(p == head)
                {
                    if(p->nach)
                    {
                        head = p->nach;
                        break;
                    }
                    neues->nach=NULL;
                    neues->vor =NULL;
                    return neues;
                }
                if(p->vor)
                {
                    p->vor->nach= p->nach;
                }
                break;

         }
    }
    neues->nach=head;
    neues->vor=NULL;
    head->vor = neues;
    return neues;

}


fach_note *entfernen(fach_note *head, fach_note **del)
{
    if(head->nach)
    {
        head->nach->vor = NULL;
        
    }
    *del=head;
    return head->nach;
}

void schleife(fach_note *liste, void (*ausgeben) (const fach_note *n))
{
    fach_note *p;
    for(p = liste ; p != NULL; p = p->nach )
    {
        ausgeben(p);
    }
    return;
}
