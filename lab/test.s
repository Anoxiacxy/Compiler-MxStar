	.text

	.globl	exchange
	.p2align	2
	.type	exchange,@function
exchange:
.L0_0:
	addi	sp, sp, -24
	sw	ra, 0(sp)
	sw	s1, 12(sp)
	sw	s2, 8(sp)
	sw	s3, 20(sp)
	sw	s4, 16(sp)
	sw	s5, 4(sp)
	mv	s3, a0
	mv	s1, a1
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	sw	s3, 0(s2)
	addi	a0, zero, 4
	call	malloc
	sw	s1, 0(a0)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	sw	t4, 0(s4)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t6, t4, t5
	lw	t4, 0(t6)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(a0)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	sw	t4, 0(t6)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(a0)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s4)
	sw	t4, 0(t5)
	j	.L0_1
.L0_1:
	lw	s1, 12(sp)
	lw	s2, 8(sp)
	lw	s3, 20(sp)
	lw	s4, 16(sp)
	lw	s5, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 24
	ret
	.size	exchange, .-exchange
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L1_0:
	addi	sp, sp, -20
	sw	ra, 8(sp)
	sw	s0, 0(sp)
	sw	s3, 16(sp)
	sw	s5, 12(sp)
	sw	s7, 4(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	call	mx__getString
	call	mx__string_parseInt
	lui	t4, %hi(n)
	sw	a0, %lo(n)(t4)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lui	t4, %hi(n)
	lw	s0, %lo(n)(t4)
	addi	t4, zero, 4
	mul	t4, s0, t4
	addi	a0, t4, 4
	call	malloc
	sw	s0, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(a)
	sw	t4, %lo(a)(t5)
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L1_1
.L1_1:
	lw	t5, 0(s3)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L1_4
	j	.L1_2
.L1_2:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	j	.L1_3
.L1_3:
	lw	t4, 0(s3)
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L1_1
.L1_4:
	call	makeHeap
	call	heapSort
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L1_5
.L1_5:
	lw	t5, 0(s3)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L1_8
	j	.L1_6
.L1_6:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	a0, 0(t4)
	call	mx__toString
	la	a1, .str.0
	call	mx__string_add
	call	mx__print
	j	.L1_7
.L1_7:
	lw	t4, 0(s3)
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L1_5
.L1_8:
	la	a0, .str.1
	call	mx__print
	sw	zero, 0(s5)
	j	.L1_10
.L1_9:
	j	.L1_10
.L1_10:
	lw	a0, 0(s5)
	lw	s0, 0(sp)
	lw	s3, 16(sp)
	lw	s5, 12(sp)
	lw	s7, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 20
	ret
	.size	main, .-main
	.globl	adjustHeap
	.p2align	2
	.type	adjustHeap,@function
adjustHeap:
.L2_0:
	addi	sp, sp, -36
	sw	ra, 4(sp)
	mv	t4, s0
	sw	t4, 16(sp)
	mv	t4, s1
	sw	t4, 32(sp)
	mv	t4, s2
	sw	t4, 12(sp)
	mv	t4, s3
	sw	t4, 24(sp)
	mv	t4, s4
	sw	t4, 8(sp)
	mv	t4, s5
	sw	t4, 28(sp)
	mv	t4, s7
	sw	t4, 0(sp)
	mv	t4, s8
	sw	t4, 20(sp)
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	sw	s4, 0(a0)
	sw	zero, 0(s5)
	sw	zero, 0(s1)
	sw	zero, 0(s7)
	j	.L2_1
.L2_1:
	lw	t4, 0(s5)
	addi	t5, zero, 2
	mul	t4, t4, t5
	lw	t5, 0(a0)
	slt	t4, t4, t5
	beqz	t4, .L2_12
	j	.L2_2
.L2_2:
	lw	t4, 0(s1)
	lw	t4, 0(s5)
	addi	t5, zero, 2
	mul	t4, t4, t5
	sw	t4, 0(s1)
	lw	t4, 0(s5)
	addi	t5, zero, 2
	mul	t4, t4, t5
	addi	t4, t4, 1
	lw	t5, 0(a0)
	slt	t4, t4, t5
	beqz	t4, .L2_3
	j	.L2_4
.L2_3:
	addi	s3, zero, 0
	j	.L2_5
.L2_4:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t6, 0(s5)
	addi	t4, zero, 2
	mul	t4, t6, t4
	addi	t4, t4, 1
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	ra, 0(t4)
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lw	t5, 0(s5)
	addi	t4, zero, 2
	mul	t4, t5, t4
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	slt	s3, ra, t4
	j	.L2_5
.L2_5:
	beqz	s3, .L2_7
	j	.L2_6
.L2_6:
	lw	t4, 0(s1)
	lw	t5, 0(s5)
	addi	t4, zero, 2
	mul	t4, t5, t4
	addi	t4, t4, 1
	sw	t4, 0(s1)
	j	.L2_8
.L2_7:
	j	.L2_8
.L2_8:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	slt	t4, t4, t5
	beqz	t4, .L2_10
	j	.L2_9
.L2_9:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	sw	t4, 0(s0)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	sw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t5, 0(s0)
	sw	t5, 0(t4)
	lw	t4, 0(s5)
	lw	t4, 0(s1)
	sw	t4, 0(s5)
	j	.L2_11
.L2_10:
	j	.L2_12
	j	.L2_11
.L2_11:
	j	.L2_1
.L2_12:
	sw	zero, 0(s2)
	j	.L2_14
.L2_13:
	j	.L2_14
.L2_14:
	lw	a0, 0(s2)
	lw	s0, 16(sp)
	lw	s1, 32(sp)
	lw	s2, 12(sp)
	lw	s3, 24(sp)
	lw	s4, 8(sp)
	lw	s5, 28(sp)
	lw	s7, 0(sp)
	lw	s8, 20(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 36
	ret
	.size	adjustHeap, .-adjustHeap
	.globl	heapSort
	.p2align	2
	.type	heapSort,@function
heapSort:
.L3_0:
	addi	sp, sp, -20
	sw	ra, 8(sp)
	sw	s0, 16(sp)
	sw	s1, 0(sp)
	sw	s2, 12(sp)
	sw	s5, 4(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	lw	t4, 0(s2)
	sw	zero, 0(s2)
	lw	t4, 0(s0)
	sw	zero, 0(s0)
	j	.L3_1
.L3_1:
	lw	t5, 0(s0)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L3_4
	j	.L3_2
.L3_2:
	lw	t4, 0(s2)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	sw	t4, 0(s2)
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	addi	t5, t4, 0
	lw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lui	t4, %hi(n)
	lw	ra, %lo(n)(t4)
	lw	t4, 0(s0)
	sub	t4, ra, t4
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	sw	t4, 0(t5)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	lw	t6, 0(s0)
	sub	t4, t4, t6
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s2)
	sw	t4, 0(t5)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	lw	t5, 0(s0)
	sub	t4, t4, t5
	addi	a0, t4, -1
	call	adjustHeap
	j	.L3_3
.L3_3:
	lw	t4, 0(s0)
	lw	t4, 0(s0)
	addi	t4, t4, 1
	sw	t4, 0(s0)
	j	.L3_1
.L3_4:
	sw	zero, 0(s1)
	j	.L3_6
.L3_5:
	j	.L3_6
.L3_6:
	lw	a0, 0(s1)
	lw	s0, 16(sp)
	lw	s1, 0(sp)
	lw	s2, 12(sp)
	lw	s5, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 20
	ret
	.size	heapSort, .-heapSort
	.globl	makeHeap
	.p2align	2
	.type	makeHeap,@function
makeHeap:
.L4_0:
	addi	sp, sp, -28
	sw	ra, 20(sp)
	mv	t4, s11
	sw	t4, 4(sp)
	mv	t4, s10
	sw	t4, 24(sp)
	mv	t4, s0
	sw	t4, 16(sp)
	mv	t4, s2
	sw	t4, 0(sp)
	mv	t4, s5
	sw	t4, 12(sp)
	mv	t4, s7
	sw	t4, 8(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	lw	t4, 0(s0)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	addi	t5, t4, -1
	addi	t4, zero, 2
	div	t4, t5, t4
	sw	t4, 0(s0)
	lw	t4, 0(s5)
	sw	zero, 0(s5)
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L4_1
.L4_1:
	lw	t4, 0(s0)
	slt	t4, t4, zero
	xori	t4, t4, 1
	beqz	t4, .L4_12
	j	.L4_2
.L4_2:
	lw	t4, 0(s11)
	lw	t5, 0(s0)
	addi	t4, zero, 2
	mul	t4, t5, t4
	sw	t4, 0(s11)
	lw	t4, 0(s0)
	addi	t5, zero, 2
	mul	t4, t4, t5
	addi	t5, t4, 1
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	slt	t4, t5, t4
	beqz	t4, .L4_3
	j	.L4_4
.L4_3:
	addi	s2, zero, 0
	j	.L4_5
.L4_4:
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lw	t4, 0(s0)
	addi	t5, zero, 2
	mul	t4, t4, t5
	addi	t4, t4, 1
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t6, 0(t4)
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s0)
	addi	ra, zero, 2
	mul	t4, t4, ra
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	slt	s2, t6, t4
	j	.L4_5
.L4_5:
	beqz	s2, .L4_7
	j	.L4_6
.L4_6:
	lw	t4, 0(s11)
	lw	t5, 0(s0)
	addi	t4, zero, 2
	mul	t4, t5, t4
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L4_8
.L4_7:
	j	.L4_8
.L4_8:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lw	t4, 0(s0)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lui	t4, %hi(a)
	lw	t6, %lo(a)(t4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	slt	t4, t4, t5
	beqz	t4, .L4_10
	j	.L4_9
.L4_9:
	lw	a0, 0(s0)
	lw	a1, 0(s11)
	call	exchange
	j	.L4_11
.L4_10:
	j	.L4_11
.L4_11:
	lw	t4, 0(s0)
	lw	t4, 0(s0)
	addi	t4, t4, -1
	sw	t4, 0(s0)
	j	.L4_1
.L4_12:
	sw	zero, 0(s10)
	j	.L4_14
.L4_13:
	j	.L4_14
.L4_14:
	lw	a0, 0(s10)
	lw	s11, 4(sp)
	lw	s10, 24(sp)
	lw	s0, 16(sp)
	lw	s2, 0(sp)
	lw	s5, 12(sp)
	lw	s7, 8(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 28
	ret
	.size	makeHeap, .-makeHeap
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L5_0:
	j	.L5_1
.L5_1:
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.global	a
	.p2align	2
	a:
	.word	0                       # 0
	.str.0:
	.asciz	"  "
	.global	n
	.p2align	2
	n:
	.word	0                       # 0
	.str.1:
	.asciz	"\n "
