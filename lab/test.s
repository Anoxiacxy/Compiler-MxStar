	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -20
	mv	s0, ra
	sw	s0, 4(sp)
	call	mx__init
	addi	s0, zero, 4
	sw	s0, 0(sp)
	lw	s0, 0(sp)
	mv	a0, s0
	call	malloc
	mv	s0, a0
	sw	s0, 16(sp)
	la	s0, .str.0
	sw	s0, 8(sp)
	lw	s0, 8(sp)
	mv	a0, s0
	call	mx__print
	j	.L0_1
.L0_1:
	lw	s1, 16(sp)
	lw	s0, 0(s1)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	mv	a0, s0
	lw	s0, 4(sp)
	mv	ra, s0
	addi	sp, sp, 20
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L1_0:
	addi	sp, sp, -4
	mv	s0, ra
	sw	s0, 0(sp)
	j	.L1_1
.L1_1:
	lw	s0, 0(sp)
	mv	ra, s0
	addi	sp, sp, 4
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.str.0:
	.asciz	"Hello World! "
