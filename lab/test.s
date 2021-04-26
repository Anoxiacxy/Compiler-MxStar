	.text

	.globl	init
	.p2align	2
	.type	init,@function
init:
.L0_0:
	addi	sp, sp, -44
	sw	ra, 0(sp)
	sw	s11, 32(sp)
	sw	s10, 16(sp)
	sw	s0, 28(sp)
	sw	s1, 40(sp)
	sw	s2, 36(sp)
	sw	s3, 20(sp)
	sw	s4, 8(sp)
	sw	s5, 24(sp)
	sw	s6, 12(sp)
	sw	s7, 4(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	call	mx__getInt
	lui	t4, %hi(n)
	sw	a0, %lo(n)(t4)
	lui	t4, %hi(m)
	lw	t4, %lo(m)(t4)
	call	mx__getInt
	lui	t4, %hi(m)
	sw	a0, %lo(m)(t4)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lui	t4, %hi(n)
	lw	s2, %lo(n)(t4)
	lui	t4, %hi(n)
	lw	s0, %lo(n)(t4)
	addi	t4, zero, 4
	mul	t4, s2, t4
	addi	a0, t4, 4
	call	malloc
	sw	s2, 0(a0)
	addi	s1, a0, 4
	slli	t4, s2, 2
	add	s5, s1, t4
	sw	s1, 0(s3)
	j	.L0_1
.L0_1:
	lw	s2, 0(s3)
	sub	t4, s2, s5
	snez	t4, t4
	beqz	t4, .L0_3
	j	.L0_2
.L0_2:
	addi	t4, zero, 4
	mul	t4, s0, t4
	addi	a0, t4, 4
	call	malloc
	sw	s0, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s2)
	addi	t4, s2, 4
	sw	t4, 0(s3)
	j	.L0_1
.L0_3:
	lui	t4, %hi(a)
	sw	s1, %lo(a)(t4)
	lw	t4, 0(s6)
	sw	zero, 0(s6)
	j	.L0_4
.L0_4:
	lw	t5, 0(s6)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_11
	j	.L0_5
.L0_5:
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_6
.L0_6:
	lw	t5, 0(s11)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_9
	j	.L0_7
.L0_7:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lui	t5, %hi(INF)
	lw	t5, %lo(INF)(t5)
	sw	t5, 0(t4)
	j	.L0_8
.L0_8:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_6
.L0_9:
	j	.L0_10
.L0_10:
	lw	t4, 0(s6)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	j	.L0_4
.L0_11:
	lw	t4, 0(s6)
	sw	zero, 0(s6)
	j	.L0_12
.L0_12:
	lw	t5, 0(s6)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_15
	j	.L0_13
.L0_13:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L0_14
.L0_14:
	lw	t4, 0(s6)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	j	.L0_12
.L0_15:
	lw	t4, 0(s6)
	sw	zero, 0(s6)
	j	.L0_16
.L0_16:
	lw	t4, 0(s6)
	lui	t5, %hi(m)
	lw	t5, %lo(m)(t5)
	slt	t4, t4, t5
	beqz	t4, .L0_19
	j	.L0_17
.L0_17:
	call	mx__getInt
	sw	a0, 0(s10)
	call	mx__getInt
	sw	a0, 0(s7)
	call	mx__getInt
	sw	a0, 0(s4)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s7)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t5, 0(s4)
	sw	t5, 0(t4)
	j	.L0_18
.L0_18:
	lw	t4, 0(s6)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	j	.L0_16
.L0_19:
	j	.L0_20
.L0_20:
	lw	s11, 32(sp)
	lw	s10, 16(sp)
	lw	s0, 28(sp)
	lw	s1, 40(sp)
	lw	s2, 36(sp)
	lw	s3, 20(sp)
	lw	s4, 8(sp)
	lw	s5, 24(sp)
	lw	s6, 12(sp)
	lw	s7, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 44
	ret
	.size	init, .-init
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L1_0:
	addi	sp, sp, -24
	sw	ra, 12(sp)
	sw	s11, 8(sp)
	sw	s10, 0(sp)
	sw	s1, 16(sp)
	sw	s2, 20(sp)
	sw	s6, 4(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	call	init
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	j	.L1_1
.L1_1:
	lw	t4, 0(s10)
	lui	t5, %hi(n)
	lw	t5, %lo(n)(t5)
	slt	t4, t4, t5
	beqz	t4, .L1_15
	j	.L1_2
.L1_2:
	lw	t4, 0(s1)
	sw	zero, 0(s1)
	j	.L1_3
.L1_3:
	lw	t4, 0(s1)
	lui	t5, %hi(n)
	lw	t5, %lo(n)(t5)
	slt	t4, t4, t5
	beqz	t4, .L1_13
	j	.L1_4
.L1_4:
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L1_5
.L1_5:
	lw	t5, 0(s11)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L1_11
	j	.L1_6
.L1_6:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s1)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lui	t5, %hi(a)
	lw	t6, %lo(a)(t5)
	lw	t5, 0(s1)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t5, 0(t5)
	lw	t6, 0(s10)
	slli	t6, t6, 2
	add	t5, t5, t6
	lw	ra, 0(t5)
	lui	t5, %hi(a)
	lw	t6, %lo(a)(t5)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t6, 0(t5)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t5, 0(t5)
	add	t5, ra, t5
	slt	t4, t5, t4
	beqz	t4, .L1_8
	j	.L1_7
.L1_7:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lui	t5, %hi(a)
	lw	t6, %lo(a)(t5)
	lw	t5, 0(s1)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t6, 0(t5)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t6, 0(t5)
	lui	t5, %hi(a)
	lw	t5, %lo(a)(t5)
	lw	ra, 0(s10)
	slli	ra, ra, 2
	add	t5, t5, ra
	lw	ra, 0(t5)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t5, ra, t5
	lw	t5, 0(t5)
	add	t5, t6, t5
	sw	t5, 0(t4)
	j	.L1_9
.L1_8:
	j	.L1_9
.L1_9:
	j	.L1_10
.L1_10:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L1_5
.L1_11:
	j	.L1_12
.L1_12:
	lw	t4, 0(s1)
	addi	t4, t4, 1
	sw	t4, 0(s1)
	j	.L1_3
.L1_13:
	j	.L1_14
.L1_14:
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L1_1
.L1_15:
	lw	t4, 0(s1)
	sw	zero, 0(s1)
	j	.L1_16
.L1_16:
	lw	t5, 0(s1)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L1_26
	j	.L1_17
.L1_17:
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L1_18
.L1_18:
	lw	t5, 0(s11)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L1_24
	j	.L1_19
.L1_19:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lui	t5, %hi(INF)
	lw	t5, %lo(INF)(t5)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L1_21
	j	.L1_20
.L1_20:
	la	a0, .str.0
	call	mx__print
	j	.L1_22
.L1_21:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__print
	j	.L1_22
.L1_22:
	la	a0, .str.1
	call	mx__print
	j	.L1_23
.L1_23:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L1_18
.L1_24:
	la	a0, .str.2
	call	mx__println
	j	.L1_25
.L1_25:
	lw	t4, 0(s1)
	addi	t4, t4, 1
	sw	t4, 0(s1)
	j	.L1_16
.L1_26:
	sw	zero, 0(s2)
	j	.L1_28
.L1_27:
	j	.L1_28
.L1_28:
	lw	a0, 0(s2)
	lw	s11, 8(sp)
	lw	s10, 0(sp)
	lw	s1, 16(sp)
	lw	s2, 20(sp)
	lw	s6, 4(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 24
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L2_0:
	j	.L2_1
.L2_1:
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.global	INF
	.p2align	2
	INF:
	.word	10000000                # 10000000
	.global	a
	.p2align	2
	a:
	.word	0                       # 0
	.str.0:
	.asciz	"-1 "
	.global	m
	.p2align	2
	m:
	.word	0                       # 0
	.global	n
	.p2align	2
	n:
	.word	0                       # 0
	.str.2:
	.asciz	" "
	.str.1:
	.asciz	"  "
