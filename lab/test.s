	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -24
	sw	ra, 0(sp)
	sw	s10, 20(sp)
	sw	s0, 12(sp)
	sw	s1, 8(sp)
	sw	s4, 4(sp)
	sw	s5, 16(sp)
	call	mx__init
	call	mx__getInt
	lui	t4, %hi(N)
	sw	a0, %lo(N)(t4)
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s10, t4, 5
	addi	t4, zero, 4
	mul	t4, s10, t4
	addi	a0, t4, 4
	call	malloc
	sw	s10, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(check)
	sw	t4, %lo(check)(t5)
	addi	t5, zero, 0
	j	.L0_1
.L0_1:
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t5
	xori	t4, t4, 1
	beqz	t4, .L0_3
	j	.L0_2
.L0_2:
	lui	t4, %hi(check)
	lw	t6, %lo(check)(t4)
	addi	t4, t5, 1
	slli	t5, t5, 2
	add	t6, t6, t5
	addi	t5, zero, 1
	sb	t5, 0(t6)
	mv	t5, t4
	j	.L0_1
.L0_3:
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s10, t4, 5
	addi	t4, zero, 4
	mul	t4, s10, t4
	addi	a0, t4, 4
	call	malloc
	sw	s10, 0(a0)
	addi	t4, a0, 4
	mv	s1, t4
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	addi	s10, t4, 5
	addi	t4, zero, 4
	mul	t4, s10, t4
	addi	a0, t4, 4
	call	malloc
	sw	s10, 0(a0)
	addi	t4, a0, 4
	mv	s4, t4
	addi	t5, s1, 4
	addi	t4, zero, 1
	sw	t4, 0(t5)
	addi	s0, zero, 2
	addi	t5, zero, 0
	j	.L0_4
.L0_4:
	addi	t4, zero, 1
	beqz	t4, .L0_22
	j	.L0_5
.L0_5:
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, s0
	beqz	t4, .L0_7
	j	.L0_6
.L0_6:
	j	.L0_22
.L0_7:
	lui	t4, %hi(check)
	lw	t4, %lo(check)(t4)
	slli	t5, s0, 2
	add	t4, t4, t5
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
	add	t4, s4, t4
	sw	s0, 0(t4)
	slli	t4, s0, 2
	add	t5, s1, t4
	addi	t4, s0, -1
	sw	t4, 0(t5)
	j	.L0_10
.L0_9:
	j	.L0_10
.L0_10:
	addi	s10, zero, 1
	j	.L0_11
.L0_11:
	lui	t4, %hi(M)
	lw	t4, %lo(M)(t4)
	slt	t4, t4, s10
	xori	t4, t4, 1
	beqz	t4, .L0_12
	j	.L0_13
.L0_12:
	addi	t4, zero, 0
	j	.L0_14
.L0_13:
	slli	t4, s10, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t5, s0, t4
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t5
	xori	t4, t4, 1
	j	.L0_14
.L0_14:
	beqz	t4, .L0_21
	j	.L0_15
.L0_15:
	slli	t4, s10, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t6, s0, t4
	lui	t4, %hi(N)
	lw	t4, %lo(N)(t4)
	slt	t4, t4, t6
	beqz	t4, .L0_17
	j	.L0_16
.L0_16:
	j	.L0_20
.L0_17:
	lui	t4, %hi(check)
	lw	t5, %lo(check)(t4)
	slli	t4, t6, 2
	add	t4, t5, t4
	sb	zero, 0(t4)
	slli	t4, s10, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	rem	t4, s0, t4
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L0_19
	j	.L0_18
.L0_18:
	slli	t4, t6, 2
	add	t5, s1, t4
	slli	t4, s0, 2
	add	t4, s1, t4
	lw	t4, 0(t4)
	slli	t6, s10, 2
	add	t6, s4, t6
	lw	t6, 0(t6)
	mul	t4, t4, t6
	sw	t4, 0(t5)
	j	.L0_21
.L0_19:
	slli	t4, s10, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	mul	t4, s0, t4
	slli	t4, t4, 2
	add	t6, s1, t4
	slli	t4, s0, 2
	add	t4, s1, t4
	lw	t5, 0(t4)
	slli	t4, s10, 2
	add	t4, s4, t4
	lw	t4, 0(t4)
	addi	t4, t4, -1
	mul	t4, t5, t4
	sw	t4, 0(t6)
	j	.L0_20
.L0_20:
	addi	t4, s10, 1
	mv	s10, t4
	mv	s10, t4
	j	.L0_11
.L0_21:
	slli	t4, s0, 2
	add	t4, s1, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__println
	addi	t4, s0, 1
	mv	s0, t4
	mv	t5, s10
	mv	s0, t4
	mv	t5, s10
	j	.L0_4
.L0_22:
	mv	a0, zero
	lw	s10, 20(sp)
	lw	s0, 12(sp)
	lw	s1, 8(sp)
	lw	s4, 4(sp)
	lw	s5, 16(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 24
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
