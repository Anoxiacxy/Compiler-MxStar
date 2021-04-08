#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

void mx__print(char* str) {
    printf("%s", str);
}

void mx__println(char* str) {
    printf("%s\n", str);
}

void mx__printInt(int n) {
    printf("%d", n);
}

void mx__printlnInt(int n) {
    printf("%d\n", n);
}

char* mx__getString() {
    char* a = malloc(sizeof(char) << 10);
    scanf("%s", a);
    return a;
}

int mx__getInt(){
    int a;
    scanf("%d",&a);
    return a;
}

char* mx__toString(int i){
    char* a = malloc(sizeof(char) << 4);
    sprintf(a, "%d", i);
    return a;
}

void* mx__malloc(int size){
    return malloc(size);
}

char* mx__str_add(char* a, char* b){
    char* tmp = malloc(sizeof(char) * (strlen(a) + strlen(b)));
    strcpy(tmp, a);
    strcat(tmp, b);
    return tmp;
}

bool mx__string_lt(char* a, char* b){
    return strcmp(a, b) < 0;
}

bool mx__string_gt(char* a, char* b){
    return strcmp(a, b) > 0;
}

bool mx__string_le(char* a, char* b){
    return strcmp(a, b) <= 0;
}

bool mx__string_ge(char* a, char* b){
    return strcmp(a, b) >= 0;
}

bool mx__string_eq(char* a,char* b){
    return strcmp(a, b) == 0;
}

bool mx__string_ne(char* a,char* b){
    return strcmp(a, b) != 0;
}

int mx__string_length(char* str){
    return strlen(str);
}

char* mx__string_substring(char* str, int left, int right) {
    char* a = malloc(sizeof(char) * (right - left + 1));
    memcpy(a, str + left, sizeof(char) * (right - left));
    a[right - left] = '\0';
    return a;
}
int mx__string_parseInt(char* str) {
    int a;
    sscanf(str, "%d", &a);
    return a;
}
int mx__string_ord(char* str, int pos){
    return str[pos];
}

