	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	mx__init
	addi	t5, zero, 0
	addi	t4, zero, 1
	addi	t6, zero, 1
	addi	a0, zero, 0
	j	.L0_1
.L0_1:
	addi	ra, zero, 10
	slt	ra, t6, ra
	beqz	ra, .L0_3
	j	.L0_2
.L0_2:
	add	a0, t5, t4
	addi	t6, t6, 1
	mv	t5, t4
	mv	t4, a0
	j	.L0_1
.L0_3:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L1_0:
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
