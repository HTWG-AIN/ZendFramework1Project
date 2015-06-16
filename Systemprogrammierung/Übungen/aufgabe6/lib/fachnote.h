/*fachnote.h*/

#ifndef FACHNOTE_H
#define FACHNOTE_H


#define NAME_LENGTH 20
enum p_arten {BENOTET, UNBENOTET};


struct strukturen
{
	struct strukturen *vor;
	struct strukturen *nach;
	char fachname[NAME_LENGTH + 1];
	enum p_arten art;
	union
	{
		int note;
		char beurteilung;   /* 'B' oder 'N' */
	}u;
};
typedef struct strukturen fach_note;



int einlesen(fach_note *n);
void ausgeben(const fach_note *n);


#endif

