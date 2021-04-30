	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	sw	s11, 12(sp)
	sw	s3, 8(sp)
	sw	s7, 4(sp)
	call	mx__init
	call	mx__getInt
	mv	s3, a0
	call	mx__getInt
	mv	s11, a0
	call	mx__getInt
	mv	a2, a0
	mv	a0, s3
	mv	a1, s11
	call	tak
	call	mx__toString
	call	mx__println
	j	.L0_2
.L0_1:
	j	.L0_2
.L0_2:
	mv	a0, zero
	lw	s11, 12(sp)
	lw	s3, 8(sp)
	lw	s7, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 16
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
	addi	sp, sp, -28
	sw	ra, 20(sp)
	sw	s11, 24(sp)
	sw	s0, 8(sp)
	sw	s1, 16(sp)
	sw	s3, 0(sp)
	sw	s7, 12(sp)
	sw	s9, 4(sp)
	mv	s3, a0
	mv	s0, a1
	mv	s11, a2
	slt	t4, s0, s3
	beqz	t4, .L2_3
	j	.L2_1
.L2_1:
	addi	a0, s3, -1
	mv	a1, s0
	mv	a2, s11
	call	tak
	mv	s1, a0
	addi	a0, s0, -1
	mv	a1, s11
	mv	a2, s3
	call	tak
	mv	s7, a0
	addi	a0, s11, -1
	mv	a1, s3
	mv	a2, s0
	call	tak
	mv	a2, a0
	mv	a0, s1
	mv	a1, s7
	call	tak
	addi	a0, a0, 1
	j	.L2_6
.L2_2:
	j	.L2_5
.L2_3:
	mv	a0, s11
	mv	a0, s11
	mv	a0, s11
	mv	a0, s11
	j	.L2_6
.L2_4:
	j	.L2_5
.L2_5:
	j	.L2_6
.L2_6:
	lw	s11, 24(sp)
	lw	s0, 8(sp)
	lw	s1, 16(sp)
	lw	s3, 0(sp)
	lw	s7, 12(sp)
	lw	s9, 4(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 28
	ret
	.size	tak, .-tak

	.section	.sdata,"aw",@progbits
