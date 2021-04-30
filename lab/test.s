	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -28
	sw	ra, 20(sp)
	sw	s11, 24(sp)
	sw	s10, 0(sp)
	sw	s2, 8(sp)
	sw	s3, 16(sp)
	sw	s4, 12(sp)
	sw	s6, 4(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	call	mx__getInt
	lui	t4, %hi(N)
	sw	a0, %lo(N)(t4)
	lui	t4, %hi(check)
	lw	t4, %lo(check)(t4)
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s3, t4, 5
	addi	t4, zero, 4
	mul	t4, s3, t4
	addi	a0, t4, 4
	call	malloc
	sw	s3, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(check)
	sw	t4, %lo(check)(t5)
	sw	zero, 0(s10)
	j	.L0_1
.L0_1:
	lw	t5, 0(s10)
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t5
	xori	t4, t4, 1
	beqz	t4, .L0_3
	j	.L0_2
.L0_2:
	lui	t4, %hi(check)
	lw	t6, %lo(check)(t4)
	lw	t5, 0(s10)
	addi	t4, t5, 1
	sw	t4, 0(s10)
	slli	t4, t5, 2
	add	t5, t6, t4
	lb	t4, 0(t5)
	addi	t4, zero, 1
	sb	t4, 0(t5)
	j	.L0_1
.L0_3:
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s3, t4, 5
	addi	t4, zero, 4
	mul	t4, s3, t4
	addi	a0, t4, 4
	call	malloc
	sw	s3, 0(a0)
	addi	t4, a0, 4
	mv	s3, t4
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s4, t4, 5
	addi	t4, zero, 4
	mul	t4, s4, t4
	addi	a0, t4, 4
	call	malloc
	sw	s4, 0(a0)
	addi	t4, a0, 4
	mv	s4, t4
	addi	t5, s3, 4
	lw	t4, 0(t5)
	addi	t4, zero, 1
	sw	t4, 0(t5)
	lw	t4, 0(s10)
	addi	t4, zero, 2
	sw	t4, 0(s10)
	j	.L0_4
.L0_4:
	addi	t4, zero, 1
	beqz	t4, .L0_22
	j	.L0_5
.L0_5:
	lw	t5, 0(s10)
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t5
	beqz	t4, .L0_7
	j	.L0_6
.L0_6:
	j	.L0_22
.L0_7:
	lui	t4, %hi(check)
	lw	t5, %lo(check)(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lb	t4, 0(t4)
	beqz	t4, .L0_9
	j	.L0_8
.L0_8:
	lui	t4, %hi(M)
	lw	t4, %lo(M)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(M)
	sw	t5, %lo(M)(t4)
	slli	t4, t5, 2
	add	t5, s4, t4
	lw	t4, 0(t5)
	lw	t4, 0(s10)
	sw	t4, 0(t5)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, s3, t4
	lw	t5, 0(t4)
	lw	t5, 0(s10)
	addi	t5, t5, -1
	sw	t5, 0(t4)
	j	.L0_10
.L0_9:
	j	.L0_10
.L0_10:
	lw	t5, 0(s10)
	sw	zero, 0(s2)
	lw	t4, 0(s2)
	addi	t4, zero, 1
	sw	t4, 0(s2)
	j	.L0_11
.L0_11:
	lw	t6, 0(s2)
	lui	t4, %hi(M)
	lw	t4, %lo(M)(t4)
	slt	t4, t4, t6
	xori	t4, t4, 1
	beqz	t4, .L0_12
	j	.L0_13
.L0_12:
	addi	t4, zero, 0
	j	.L0_14
.L0_13:
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t6, t5, t4
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t6
	xori	t4, t4, 1
	j	.L0_14
.L0_14:
	beqz	t4, .L0_21
	j	.L0_15
.L0_15:
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t4, t5, t4
	lui	t6, %hi(N)
	lw	t6, %lo(N)(t6)
	slt	t6, t6, t4
	beqz	t6, .L0_17
	j	.L0_16
.L0_16:
	j	.L0_20
.L0_17:
	lui	t6, %hi(check)
	lw	ra, %lo(check)(t6)
	slli	t6, t4, 2
	add	ra, ra, t6
	lb	t6, 0(ra)
	sb	zero, 0(ra)
	lw	t6, 0(s2)
	slli	t6, t6, 2
	add	t6, s4, t6
	lw	t6, 0(t6)
	rem	t6, t5, t6
	addi	t6, t6, 0
	seqz	t6, t6
	beqz	t6, .L0_19
	j	.L0_18
.L0_18:
	slli	t4, t4, 2
	add	t6, s3, t4
	lw	t4, 0(t6)
	slli	t4, t5, 2
	add	t4, s3, t4
	lw	ra, 0(t4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t4, ra, t4
	sw	t4, 0(t6)
	j	.L0_21
.L0_19:
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t4, t5, t4
	slli	t4, t4, 2
	add	ra, s3, t4
	lw	t4, 0(ra)
	slli	t4, t5, 2
	add	t4, s3, t4
	lw	t6, 0(t4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	addi	t4, t4, -1
	mul	t4, t6, t4
	sw	t4, 0(ra)
	j	.L0_20
.L0_20:
	lw	t4, 0(s2)
	addi	t4, t4, 1
	sw	t4, 0(s2)
	j	.L0_11
.L0_21:
	slli	t4, t5, 2
	add	t4, s3, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__println
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L0_4
.L0_22:
	sw	zero, 0(s11)
	lw	a0, 0(s11)
	lw	s11, 24(sp)
	lw	s10, 0(sp)
	lw	s2, 8(sp)
	lw	s3, 16(sp)
	lw	s4, 12(sp)
	lw	s6, 4(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 28
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
	.global	check
	.p2align	2
	check:
	.word	0                       # 0
	.global	M
	.p2align	2
	M:
	.word	0                       # 0
	.global	N
	.p2align	2
	N:
	.word	0                       # 0
