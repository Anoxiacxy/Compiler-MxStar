	.text

	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L0_0:
	j	.L0_1
.L0_1:
	ret
	.size	mx__init, .-mx__init
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L1_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	mx__init
	addi	t0, zero, 0
	addi	ra, zero, 1
	addi	a0, zero, 0
	addi	t1, zero, 1
	j	.L1_1
.L1_1:
	addi	t2, zero, 10
	slt	t2, t1, t2
	beqz	t2, .L1_4
	j	.L1_2
.L1_2:
	add	a0, t0, ra
	j	.L1_3
.L1_3:
	addi	t1, t1, 1
	mv	t0, ra
	mv	ra, a0
	j	.L1_1
.L1_4:
	j	.L1_6
.L1_5:
	j	.L1_6
.L1_6:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	main, .-main

	.section	.sdata,"aw",@progbits
