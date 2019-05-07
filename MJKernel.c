SYSCALL_DEFINE0(mj1)
{
    long error = 0
    printk(KERN_INFO "\n*** mj1 ***\n");
    return error;
}

/* 
 * What: /usr/include/cs232.h
 * Who: Micah Bonewell & Joshua Wilson
 * What: Kernel Project, CS 232
 * Where: Calvin College
 * When: April 2019.
 */

#include <unistd.h>
#include <sys/syscall.h>
#include <syslog.h>

#define SYS_mj1 333

static inline
long mj1(void) {
    printk(KERN_INFO "\n*** mj1 ***\n");
	return syscall(SYS_CS232);
}

/* test-cs232.c tests the cs232() system call.
 * Prof. Adams, for the Kernel Project,
 * CS 232 at Calvin College, March 2019.
 */

#include <stdio.h>
#include <cs232.h>

int main(){
	printf("Invoking system call...\n");
	long result = cs232();
	printf("System call returned %ld\n", result);
	return 0;
}