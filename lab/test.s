	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -20
	sw	ra, 4(sp)
	sw	s11, 12(sp)
	sw	s0, 16(sp)
	sw	s1, 8(sp)
	sw	s5, 0(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	sw	zero, 0(s0)
	call	mx__getInt
	mv	s1, a0
	call	mx__getInt
	mv	s11, a0
	call	mx__getInt
	mv	a2, a0
	mv	a0, s1
	mv	a1, s11
	call	tak
	call	mx__toString
	call	mx__println
	sw	zero, 0(s0)
	j	.L0_2
.L0_1:
	j	.L0_2
.L0_2:
	lw	a0, 0(s0)
	lw	s11, 12(sp)
	lw	s0, 16(sp)
	lw	s1, 8(sp)
	lw	s5, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 20
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L1_0:
	j	.L1_1
.L1_1:
	ret
	.size	mx__init, .-mx__init
	.globl	tak
	.p2align	2
	.type	tak,@function
tak:
.L2_0:
	addi	sp, sp, -32
	sw	ra, 24(sp)
	sw	s10, 20(sp)
	sw	s0, 16(sp)
	sw	s2, 28(sp)
	sw	s4, 0(sp)
	sw	s5, 8(sp)
	sw	s8, 12(sp)
	sw	s9, 4(sp)
	mv	s0, a0
	mv	s4, a1
	mv	s10, a2
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	sw	zero, 0(s2)
	mv	t4, s4
	slt	t4, t4, s0
	beqz	t4, .L2_3
	j	.L2_1
.L2_1:
	addi	a0, s0, -1
	mv	a1, s4
	mv	a2, s10
	call	tak
	mv	s5, a0
	addi	a0, s4, -1
	mv	a1, s10
	mv	a2, s0
	call	tak
	mv	s8, a0
	mv	t4, s10
	addi	a0, t4, -1
	mv	a1, s0
	mv	a2, s4
	call	tak
	mv	a2, a0
	mv	a0, s5
	mv	a1, s8
	call	tak
	addi	t4, a0, 1
	sw	t4, 0(s2)
	j	.L2_6
.L2_2:
	j	.L2_5
.L2_3:
	sw	s10, 0(s2)
	j	.L2_6
.L2_4:
	j	.L2_5
.L2_5:
	j	.L2_6
.L2_6:
	lw	a0, 0(s2)
	lw	s10, 20(sp)
	lw	s0, 16(sp)
	lw	s2, 28(sp)
	lw	s4, 0(sp)
	lw	s5, 8(sp)
	lw	s8, 12(sp)
	lw	s9, 4(sp)
	lw	ra, 24(sp)
	addi	sp, sp, 32
	ret
	.size	tak, .-tak

	.section	.sdata,"aw",@progbits
