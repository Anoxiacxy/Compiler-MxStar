	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -24
	sw	ra, 4(sp)
	sw	s11, 8(sp)
	sw	s0, 16(sp)
	sw	s2, 20(sp)
	sw	s3, 0(sp)
	sw	s4, 12(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	sw	zero, 0(s3)
	addi	t4, zero, 4
	addi	t5, zero, 4
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 4
	sw	t4, 0(a0)
	addi	t4, a0, 4
	mv	s2, t4
	sw	zero, 0(s11)
	mv	t4, s2
	addi	t5, t4, 0
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	sw	t4, 0(t5)
	mv	t4, s2
	addi	t5, t4, 4
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	sw	t4, 0(t5)
	mv	t4, s2
	addi	t5, t4, 8
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	sw	t4, 0(t5)
	mv	t4, s2
	addi	t5, t4, 12
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	sw	t4, 0(t5)
	mv	t4, s2
	addi	t4, t4, -4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__println
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_1
.L0_1:
	lw	t5, 0(s11)
	mv	t4, s2
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_4
	j	.L0_2
.L0_2:
	mv	t4, s2
	addi	t4, t4, 0
	lw	t4, 0(t4)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	s0, t4, t5
	lw	t4, 0(s0)
	call	mx__getInt
	sw	a0, 0(s0)
	j	.L0_3
.L0_3:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_1
.L0_4:
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_5
.L0_5:
	lw	t5, 0(s11)
	mv	t4, s2
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_8
	j	.L0_6
.L0_6:
	mv	t4, s2
	addi	t4, t4, 4
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__print
	j	.L0_7
.L0_7:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_5
.L0_8:
	la	a0, .str.0
	call	mx__println
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_9
.L0_9:
	lw	t5, 0(s11)
	mv	t4, s2
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_12
	j	.L0_10
.L0_10:
	mv	t4, s2
	addi	t4, t4, 8
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	j	.L0_11
.L0_11:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_9
.L0_12:
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_13
.L0_13:
	lw	t5, 0(s11)
	mv	t4, s2
	addi	t4, t4, 12
	lw	t4, 0(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_16
	j	.L0_14
.L0_14:
	mv	t4, s2
	addi	t4, t4, 12
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__print
	j	.L0_15
.L0_15:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_13
.L0_16:
	sw	zero, 0(s3)
	j	.L0_18
.L0_17:
	j	.L0_18
.L0_18:
	lw	a0, 0(s3)
	lw	s11, 8(sp)
	lw	s0, 16(sp)
	lw	s2, 20(sp)
	lw	s3, 0(sp)
	lw	s4, 12(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 24
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L1_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	t5, zero, 4
	addi	t4, zero, 4
	mul	t4, t5, t4
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 4
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(a)
	sw	t4, %lo(a)(t5)
	j	.L1_1
.L1_1:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.global	a
	.p2align	2
	a:
	.word	0                       # 0
	.str.0:
	.asciz	" "
