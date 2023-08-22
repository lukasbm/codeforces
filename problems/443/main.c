#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char* args[]){

	char buf[1001];
	if(fgets(buf, 1001, stdin)){
		if(ferror(stdin)) exit(EXIT_FAILURE);
	}


	int alph[26] = {0};

	for(int i = 0; i < 1001; i++){
		if(buf [i] == '{') continue;
		if(buf[i] == ' ') continue;
		if(buf[i] == ',') continue;
		if(buf[i] == '}') break;
		alph[  ((int)buf[i]) - 97 ]++;
	}

	int erg = 0;
	for(int i = 0; i < 26; i++){
		if (alph[i] > 0) erg++;
	}
	printf("%d", erg);

	exit(EXIT_SUCCESS);
}