	.text

	.globl	add
	.p2align	2
	.type	add,@function
add:
.L0_0:
	li	t4, 65535
	and	t4, a0, t4
	li	t5, 65535
	and	t5, a1, t5
	add	t4, t4, t5
	srai	t5, a0, 16
	li	t6, 65535
	and	t6, t5, t6
	srai	a0, a1, 16
	li	t5, 65535
	and	t5, a0, t5
	add	t6, t6, t5
	srai	t5, t4, 16
	add	t6, t6, t5
	li	t5, 65535
	and	t5, t6, t5
	slli	t5, t5, 16
	li	t6, 65535
	and	t4, t4, t6
	or	a0, t5, t4
	j	.L0_2
.L0_1:
	j	.L0_2
.L0_2:
	ret
	.size	add, .-add
	.globl	nextText
	.p2align	2
	.type	nextText,@function
nextText:
.L1_0:
	addi	sp, sp, -24
	sw	ra, 16(sp)
	sw	s11, 8(sp)
	sw	s1, 0(sp)
	sw	s3, 12(sp)
	sw	s4, 20(sp)
	sw	s5, 4(sp)
	mv	s3, a0
	mv	s4, a1
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 1
	call	malloc
	mv	s1, a0
	lw	t4, 0(s11)
	addi	t4, s4, -1
	sw	t4, 0(s11)
	j	.L1_1
.L1_1:
	lw	t4, 0(s11)
	slt	t4, t4, zero
	xori	t4, t4, 1
	beqz	t4, .L1_8
	j	.L1_2
.L1_2:
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	s4, s3, t4
	lw	t4, 0(s4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, s3, t4
	lw	a0, 0(t4)
	call	nextLetter
	sw	a0, 0(s4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, s3, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	beqz	t4, .L1_4
	j	.L1_3
.L1_3:
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t5, s3, t4
	lw	t4, 0(t5)
	addi	t4, zero, 48
	sw	t4, 0(t5)
	j	.L1_6
.L1_4:
	addi	t4, zero, 1
	sb	t4, 0(s1)
	j	.L1_10
.L1_5:
	j	.L1_6
.L1_6:
	j	.L1_7
.L1_7:
	lw	t4, 0(s11)
	addi	t4, t4, -1
	sw	t4, 0(s11)
	j	.L1_1
.L1_8:
	sb	zero, 0(s1)
	j	.L1_10
.L1_9:
	j	.L1_10
.L1_10:
	lb	a0, 0(s1)
	lw	s11, 8(sp)
	lw	s1, 0(sp)
	lw	s3, 12(sp)
	lw	s4, 20(sp)
	lw	s5, 4(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 24
	ret
	.size	nextText, .-nextText
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L2_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	mv	t4, s11
	sw	t4, 0(sp)
	mv	t4, s10
	sw	t4, 8(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	j	.L2_1
.L2_1:
	addi	t4, zero, 1
	beqz	t4, .L2_12
	j	.L2_2
.L2_2:
	call	mx__getInt
	mv	s11, a0
	addi	t4, s11, 0
	seqz	t4, t4
	beqz	t4, .L2_4
	j	.L2_3
.L2_3:
	j	.L2_12
	j	.L2_5
.L2_4:
	j	.L2_5
.L2_5:
	addi	t4, s11, -1
	seqz	t4, t4
	beqz	t4, .L2_7
	j	.L2_6
.L2_6:
	lw	t4, 0(s10)
	call	mx__getString
	sw	a0, 0(s10)
	lw	a0, 0(s10)
	call	computeSHA1
	j	.L2_11
.L2_7:
	addi	t4, s11, -2
	seqz	t4, t4
	beqz	t4, .L2_9
	j	.L2_8
.L2_8:
	lw	t4, 0(s10)
	call	mx__getString
	sw	a0, 0(s10)
	lw	a0, 0(s10)
	call	crackSHA1
	j	.L2_10
.L2_9:
	j	.L2_10
.L2_10:
	j	.L2_11
.L2_11:
	j	.L2_1
.L2_12:
	j	.L2_14
.L2_13:
	j	.L2_14
.L2_14:
	addi	a0, zero, 0
	lw	s11, 0(sp)
	lw	s10, 8(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	main, .-main
	.globl	hex2int
	.p2align	2
	.type	hex2int,@function
hex2int:
.L3_0:
	addi	sp, sp, -28
	sw	ra, 16(sp)
	sw	s10, 8(sp)
	sw	s1, 24(sp)
	sw	s2, 0(sp)
	sw	s3, 20(sp)
	sw	s4, 12(sp)
	sw	s7, 4(sp)
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	sw	zero, 0(s1)
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L3_1
.L3_1:
	lw	s10, 0(s3)
	mv	a0, s4
	call	mx__string_length
	slt	t4, s10, a0
	beqz	t4, .L3_26
	j	.L3_2
.L3_2:
	mv	a0, s4
	lw	a1, 0(s3)
	call	mx__string_ord
	addi	t4, zero, 48
	slt	t4, a0, t4
	xori	t4, t4, 1
	beqz	t4, .L3_4
	j	.L3_5
.L3_3:
	addi	t4, zero, 0
	j	.L3_6
.L3_4:
	addi	t4, zero, 0
	j	.L3_6
.L3_5:
	addi	t4, zero, 57
	slt	t4, t4, a0
	xori	t4, t4, 1
	j	.L3_6
.L3_6:
	beqz	t4, .L3_8
	j	.L3_7
.L3_7:
	lw	t4, 0(s1)
	lw	t5, 0(s1)
	addi	t4, zero, 16
	mul	t4, t5, t4
	add	t4, t4, a0
	addi	t4, t4, -48
	sw	t4, 0(s1)
	j	.L3_24
.L3_8:
	addi	t4, zero, 65
	slt	t4, a0, t4
	xori	t4, t4, 1
	beqz	t4, .L3_10
	j	.L3_11
.L3_9:
	addi	t4, zero, 0
	j	.L3_12
.L3_10:
	addi	t4, zero, 0
	j	.L3_12
.L3_11:
	addi	t4, zero, 70
	slt	t4, t4, a0
	xori	t4, t4, 1
	j	.L3_12
.L3_12:
	beqz	t4, .L3_14
	j	.L3_13
.L3_13:
	lw	t4, 0(s1)
	lw	t5, 0(s1)
	addi	t4, zero, 16
	mul	t4, t5, t4
	add	t4, t4, a0
	addi	t4, t4, -65
	addi	t4, t4, 10
	sw	t4, 0(s1)
	j	.L3_23
.L3_14:
	addi	t4, zero, 97
	slt	t4, a0, t4
	xori	t4, t4, 1
	beqz	t4, .L3_16
	j	.L3_17
.L3_15:
	addi	t4, zero, 0
	j	.L3_18
.L3_16:
	addi	t4, zero, 0
	j	.L3_18
.L3_17:
	addi	t4, zero, 102
	slt	t4, t4, a0
	xori	t4, t4, 1
	j	.L3_18
.L3_18:
	beqz	t4, .L3_20
	j	.L3_19
.L3_19:
	lw	t4, 0(s1)
	lw	t4, 0(s1)
	addi	t5, zero, 16
	mul	t4, t4, t5
	add	t4, t4, a0
	addi	t4, t4, -97
	addi	t4, t4, 10
	sw	t4, 0(s1)
	j	.L3_22
.L3_20:
	sw	zero, 0(s2)
	j	.L3_28
.L3_21:
	j	.L3_22
.L3_22:
	j	.L3_23
.L3_23:
	j	.L3_24
.L3_24:
	j	.L3_25
.L3_25:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L3_1
.L3_26:
	lw	t4, 0(s1)
	sw	t4, 0(s2)
	j	.L3_28
.L3_27:
	j	.L3_28
.L3_28:
	lw	a0, 0(s2)
	lw	s10, 8(sp)
	lw	s1, 24(sp)
	lw	s2, 0(sp)
	lw	s3, 20(sp)
	lw	s4, 12(sp)
	lw	s7, 4(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 28
	ret
	.size	hex2int, .-hex2int
	.globl	crackSHA1
	.p2align	2
	.type	crackSHA1,@function
crackSHA1:
.L4_0:
	addi	sp, sp, -28
	sw	ra, 20(sp)
	sw	s10, 4(sp)
	sw	s1, 24(sp)
	sw	s2, 8(sp)
	sw	s3, 16(sp)
	sw	s4, 12(sp)
	sw	s5, 0(sp)
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	t5, zero, 4
	addi	t4, zero, 5
	mul	t4, t5, t4
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 5
	sw	t4, 0(a0)
	addi	s10, a0, 4
	mv	a0, s1
	call	mx__string_length
	addi	t4, a0, -40
	snez	t4, t4
	beqz	t4, .L4_3
	j	.L4_1
.L4_1:
	la	a0, .str.3
	call	mx__println
	j	.L4_35
.L4_2:
	j	.L4_4
.L4_3:
	j	.L4_4
.L4_4:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L4_5
.L4_5:
	lw	t5, 0(s3)
	addi	t4, zero, 5
	slt	t4, t5, t4
	beqz	t4, .L4_8
	j	.L4_6
.L4_6:
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t5, s10, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L4_7
.L4_7:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L4_5
.L4_8:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L4_9
.L4_9:
	lw	t5, 0(s3)
	addi	t4, zero, 40
	slt	t4, t5, t4
	beqz	t4, .L4_12
	j	.L4_10
.L4_10:
	lw	t5, 0(s3)
	addi	t4, zero, 8
	div	t4, t5, t4
	slli	t4, t4, 2
	add	s2, s10, t4
	lw	t4, 0(s2)
	lw	t5, 0(s3)
	addi	t4, zero, 8
	div	t4, t5, t4
	slli	t4, t4, 2
	add	t4, s10, t4
	lw	s4, 0(t4)
	mv	a0, s1
	lw	a1, 0(s3)
	lw	t4, 0(s3)
	addi	a2, t4, 4
	call	mx__string_substring
	call	hex2int
	lw	t4, 0(s3)
	addi	t5, zero, 4
	div	t5, t4, t5
	addi	t4, zero, 2
	rem	t4, t5, t4
	addi	t5, zero, 1
	sub	t5, t5, t4
	addi	t4, zero, 16
	mul	t4, t5, t4
	sll	t4, a0, t4
	or	t4, s4, t4
	sw	t4, 0(s2)
	j	.L4_11
.L4_11:
	lw	t4, 0(s3)
	lw	t4, 0(s3)
	addi	t4, t4, 4
	sw	t4, 0(s3)
	j	.L4_9
.L4_12:
	lw	t4, 0(s5)
	addi	t4, zero, 1
	sw	t4, 0(s5)
	j	.L4_13
.L4_13:
	lw	t4, 0(s5)
	addi	t5, zero, 4
	slt	t4, t5, t4
	xori	t4, t4, 1
	beqz	t4, .L4_34
	j	.L4_14
.L4_14:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L4_15
.L4_15:
	lw	t5, 0(s3)
	lw	t4, 0(s5)
	slt	t4, t5, t4
	beqz	t4, .L4_18
	j	.L4_16
.L4_16:
	lui	t4, %hi(inputBuffer)
	lw	t5, %lo(inputBuffer)(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	addi	t5, zero, 48
	sw	t5, 0(t4)
	j	.L4_17
.L4_17:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L4_15
.L4_18:
	j	.L4_19
.L4_19:
	addi	t4, zero, 1
	beqz	t4, .L4_32
	j	.L4_20
.L4_20:
	lui	t4, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(t4)
	lw	a1, 0(s5)
	call	sha1
	mv	a1, s10
	call	array_equal
	beqz	a0, .L4_27
	j	.L4_21
.L4_21:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L4_22
.L4_22:
	lw	t5, 0(s3)
	lw	t4, 0(s5)
	slt	t4, t5, t4
	beqz	t4, .L4_25
	j	.L4_23
.L4_23:
	lui	t4, %hi(inputBuffer)
	lw	t4, %lo(inputBuffer)(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	a0, 0(t4)
	call	int2chr
	call	mx__print
	j	.L4_24
.L4_24:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L4_22
.L4_25:
	la	a0, .str.1
	call	mx__println
	j	.L4_35
.L4_26:
	j	.L4_28
.L4_27:
	j	.L4_28
.L4_28:
	lui	t4, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(t4)
	lw	a1, 0(s5)
	call	nextText
	xori	t4, a0, 1
	beqz	t4, .L4_30
	j	.L4_29
.L4_29:
	j	.L4_32
	j	.L4_31
.L4_30:
	j	.L4_31
.L4_31:
	j	.L4_19
.L4_32:
	j	.L4_33
.L4_33:
	lw	t4, 0(s5)
	addi	t4, t4, 1
	sw	t4, 0(s5)
	j	.L4_13
.L4_34:
	la	a0, .str.4
	call	mx__println
	j	.L4_35
.L4_35:
	lw	s10, 4(sp)
	lw	s1, 24(sp)
	lw	s2, 8(sp)
	lw	s3, 16(sp)
	lw	s4, 12(sp)
	lw	s5, 0(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 28
	ret
	.size	crackSHA1, .-crackSHA1
	.globl	toStringHex
	.p2align	2
	.type	toStringHex,@function
toStringHex:
.L5_0:
	addi	sp, sp, -24
	sw	ra, 16(sp)
	sw	s11, 0(sp)
	sw	s1, 20(sp)
	sw	s5, 8(sp)
	sw	s6, 12(sp)
	sw	s7, 4(sp)
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	la	t4, .str.1
	sw	t4, 0(s11)
	lw	t4, 0(s1)
	addi	t4, zero, 28
	sw	t4, 0(s1)
	j	.L5_1
.L5_1:
	lw	t4, 0(s1)
	slt	t4, t4, zero
	xori	t4, t4, 1
	beqz	t4, .L5_7
	j	.L5_2
.L5_2:
	lw	t4, 0(s1)
	sra	t4, s5, t4
	andi	t4, t4, 15
	addi	t5, zero, 10
	slt	t5, t4, t5
	beqz	t5, .L5_4
	j	.L5_3
.L5_3:
	lw	t5, 0(s11)
	lw	s6, 0(s11)
	addi	a0, t4, 48
	call	int2chr
	mv	a1, a0
	mv	a0, s6
	call	mx__string_add
	sw	a0, 0(s11)
	j	.L5_5
.L5_4:
	lw	t5, 0(s11)
	lw	s6, 0(s11)
	addi	t4, t4, 65
	addi	a0, t4, -10
	call	int2chr
	mv	a1, a0
	mv	a0, s6
	call	mx__string_add
	sw	a0, 0(s11)
	j	.L5_5
.L5_5:
	j	.L5_6
.L5_6:
	lw	t4, 0(s1)
	lw	t4, 0(s1)
	addi	t4, t4, -4
	sw	t4, 0(s1)
	j	.L5_1
.L5_7:
	lw	a0, 0(s11)
	j	.L5_9
.L5_8:
	j	.L5_9
.L5_9:
	lw	s11, 0(sp)
	lw	s1, 20(sp)
	lw	s5, 8(sp)
	lw	s6, 12(sp)
	lw	s7, 4(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 24
	ret
	.size	toStringHex, .-toStringHex
	.globl	computeSHA1
	.p2align	2
	.type	computeSHA1,@function
computeSHA1:
.L6_0:
	addi	sp, sp, -16
	sw	ra, 8(sp)
	sw	s11, 0(sp)
	sw	s0, 12(sp)
	sw	s2, 4(sp)
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L6_1
.L6_1:
	lw	s2, 0(s11)
	mv	a0, s0
	call	mx__string_length
	slt	t4, s2, a0
	beqz	t4, .L6_4
	j	.L6_2
.L6_2:
	lui	t4, %hi(inputBuffer)
	lw	t4, %lo(inputBuffer)(t4)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	s2, t4, t5
	lw	t4, 0(s2)
	mv	a0, s0
	lw	a1, 0(s11)
	call	mx__string_ord
	sw	a0, 0(s2)
	j	.L6_3
.L6_3:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L6_1
.L6_4:
	lui	t4, %hi(inputBuffer)
	lw	s2, %lo(inputBuffer)(t4)
	mv	a0, s0
	call	mx__string_length
	mv	a1, a0
	mv	a0, s2
	call	sha1
	mv	s0, a0
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L6_5
.L6_5:
	lw	t5, 0(s11)
	mv	t4, s0
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L6_8
	j	.L6_6
.L6_6:
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, s0, t4
	lw	a0, 0(t4)
	call	toStringHex
	call	mx__print
	j	.L6_7
.L6_7:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L6_5
.L6_8:
	la	a0, .str.1
	call	mx__println
	j	.L6_9
.L6_9:
	lw	s11, 0(sp)
	lw	s0, 12(sp)
	lw	s2, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 16
	ret
	.size	computeSHA1, .-computeSHA1
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L7_0:
	addi	sp, sp, -24
	sw	ra, 16(sp)
	sw	s10, 4(sp)
	sw	s0, 0(sp)
	sw	s2, 12(sp)
	sw	s6, 20(sp)
	sw	s7, 8(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	la	t5, .str.0
	lui	t4, %hi(asciiTable)
	sw	t5, %lo(asciiTable)(t4)
	lui	t4, %hi(MAXCHUNK)
	lw	t4, %lo(MAXCHUNK)(t4)
	addi	t5, t4, -1
	addi	t4, zero, 64
	mul	t4, t5, t4
	addi	t5, t4, -16
	lui	t4, %hi(MAXLENGTH)
	sw	t5, %lo(MAXLENGTH)(t4)
	lui	t4, %hi(MAXCHUNK)
	lw	s10, %lo(MAXCHUNK)(t4)
	addi	t4, zero, 4
	mul	t4, s10, t4
	addi	a0, t4, 4
	call	malloc
	sw	s10, 0(a0)
	addi	s6, a0, 4
	slli	t4, s10, 2
	add	s10, s6, t4
	sw	s6, 0(s2)
	j	.L7_1
.L7_1:
	lw	s0, 0(s2)
	sub	t4, s0, s10
	snez	t4, t4
	beqz	t4, .L7_3
	j	.L7_2
.L7_2:
	addi	t5, zero, 4
	addi	t4, zero, 80
	mul	t4, t5, t4
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 80
	sw	t4, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s0)
	addi	t4, s0, 4
	sw	t4, 0(s2)
	j	.L7_1
.L7_3:
	lui	t4, %hi(chunks)
	sw	s6, %lo(chunks)(t4)
	lui	t4, %hi(MAXLENGTH)
	lw	s10, %lo(MAXLENGTH)(t4)
	addi	t4, zero, 4
	mul	t4, s10, t4
	addi	a0, t4, 4
	call	malloc
	sw	s10, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(inputBuffer)
	sw	t4, %lo(inputBuffer)(t5)
	addi	t4, zero, 4
	addi	t5, zero, 5
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 5
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(outputBuffer)
	sw	t4, %lo(outputBuffer)(t5)
	j	.L7_4
.L7_4:
	lw	s10, 4(sp)
	lw	s0, 0(sp)
	lw	s2, 12(sp)
	lw	s6, 20(sp)
	lw	s7, 8(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 24
	ret
	.size	mx__init, .-mx__init
	.globl	sha1
	.p2align	2
	.type	sha1,@function
sha1:
.L8_0:
	addi	sp, sp, -88
	sw	ra, 20(sp)
	sw	s11, 16(sp)
	sw	s10, 28(sp)
	sw	s0, 84(sp)
	sw	s1, 60(sp)
	sw	s2, 72(sp)
	sw	s3, 40(sp)
	sw	s4, 48(sp)
	sw	s5, 4(sp)
	sw	s6, 56(sp)
	sw	s7, 8(sp)
	sw	s8, 32(sp)
	sw	s9, 80(sp)
	sw	a0, 76(sp)
	sw	a1, 52(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 68(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s9, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 64(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s8, a0
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 36(sp)
	lw	t4, 52(sp)
	addi	t4, t4, 64
	addi	t4, t4, -56
	addi	t5, zero, 64
	div	t4, t4, t5
	addi	t4, t4, 1
	sw	t4, 0(sp)
	lw	t4, 0(sp)
	lui	t5, %hi(MAXCHUNK)
	lw	t5, %lo(MAXCHUNK)(t5)
	slt	t4, t5, t4
	beqz	t4, .L8_3
	j	.L8_1
.L8_1:
	la	a0, .str.2
	call	mx__println
	lw	t4, 36(sp)
	sw	zero, 0(t4)
	j	.L8_39
.L8_2:
	j	.L8_4
.L8_3:
	j	.L8_4
.L8_4:
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	j	.L8_5
.L8_5:
	lw	t5, 0(s10)
	lw	t4, 0(sp)
	slt	t4, t5, t4
	beqz	t4, .L8_12
	j	.L8_6
.L8_6:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L8_7
.L8_7:
	lw	t4, 0(s3)
	addi	t5, zero, 80
	slt	t4, t4, t5
	beqz	t4, .L8_10
	j	.L8_8
.L8_8:
	lui	t4, %hi(chunks)
	lw	t5, %lo(chunks)(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	j	.L8_9
.L8_9:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L8_7
.L8_10:
	j	.L8_11
.L8_11:
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L8_5
.L8_12:
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	j	.L8_13
.L8_13:
	lw	t5, 0(s10)
	lw	t4, 52(sp)
	slt	t4, t5, t4
	beqz	t4, .L8_16
	j	.L8_14
.L8_14:
	lui	t4, %hi(chunks)
	lw	t4, %lo(chunks)(t4)
	lw	t5, 0(s10)
	addi	t6, zero, 64
	div	t5, t5, t6
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t6, 0(s10)
	addi	t5, zero, 64
	rem	t5, t6, t5
	addi	t6, zero, 4
	div	t5, t5, t6
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lui	t4, %hi(chunks)
	lw	t6, %lo(chunks)(t4)
	lw	ra, 0(s10)
	addi	t4, zero, 64
	div	t4, ra, t4
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t6, 0(t4)
	lw	ra, 0(s10)
	addi	t4, zero, 64
	rem	ra, ra, t4
	addi	t4, zero, 4
	div	t4, ra, t4
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t6, 0(t4)
	lw	t4, 76(sp)
	lw	ra, 0(s10)
	slli	ra, ra, 2
	add	t4, t4, ra
	lw	ra, 0(t4)
	lw	a0, 0(s10)
	addi	t4, zero, 4
	rem	a0, a0, t4
	addi	t4, zero, 3
	sub	a0, t4, a0
	addi	t4, zero, 8
	mul	t4, a0, t4
	sll	t4, ra, t4
	or	t4, t6, t4
	sw	t4, 0(t5)
	j	.L8_15
.L8_15:
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L8_13
.L8_16:
	lui	t4, %hi(chunks)
	lw	t4, %lo(chunks)(t4)
	lw	t5, 0(s10)
	addi	t6, zero, 64
	div	t5, t5, t6
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s10)
	addi	t6, zero, 64
	rem	t5, t5, t6
	addi	t6, zero, 4
	div	t5, t5, t6
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lui	t5, %hi(chunks)
	lw	ra, %lo(chunks)(t5)
	lw	t6, 0(s10)
	addi	t5, zero, 64
	div	t5, t6, t5
	slli	t5, t5, 2
	add	t5, ra, t5
	lw	ra, 0(t5)
	lw	t6, 0(s10)
	addi	t5, zero, 64
	rem	t5, t6, t5
	addi	t6, zero, 4
	div	t5, t5, t6
	slli	t5, t5, 2
	add	t5, ra, t5
	lw	t6, 0(t5)
	lw	t5, 0(s10)
	addi	ra, zero, 4
	rem	t5, t5, ra
	addi	ra, zero, 3
	sub	t5, ra, t5
	addi	ra, zero, 8
	mul	ra, t5, ra
	addi	t5, zero, 128
	sll	t5, t5, ra
	or	t5, t6, t5
	sw	t5, 0(t4)
	lui	t4, %hi(chunks)
	lw	t5, %lo(chunks)(t4)
	lw	t4, 0(sp)
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t5, t4, 60
	lw	t4, 0(t5)
	lw	t4, 52(sp)
	slli	t4, t4, 3
	sw	t4, 0(t5)
	lui	t4, %hi(chunks)
	lw	t5, %lo(chunks)(t4)
	lw	t4, 0(sp)
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t5, t4, 56
	lw	t4, 0(t5)
	lw	t4, 52(sp)
	srai	t4, t4, 29
	andi	t4, t4, 7
	sw	t4, 0(t5)
	li	t4, 1732584193
	sw	t4, 0(s6)
	li	a0, 43913
	li	a1, 61389
	call	lohi
	sw	a0, 0(s7)
	li	a0, 56574
	li	a1, 39098
	call	lohi
	sw	a0, 0(s8)
	li	t4, 271733878
	lw	t5, 64(sp)
	sw	t4, 0(t5)
	li	a0, 57840
	li	a1, 50130
	call	lohi
	sw	a0, 0(s9)
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	j	.L8_17
.L8_17:
	lw	t5, 0(s10)
	lw	t4, 0(sp)
	slt	t4, t5, t4
	beqz	t4, .L8_37
	j	.L8_18
.L8_18:
	lw	t4, 0(s3)
	addi	t4, zero, 16
	sw	t4, 0(s3)
	j	.L8_19
.L8_19:
	lw	t5, 0(s3)
	addi	t4, zero, 80
	slt	t4, t5, t4
	beqz	t4, .L8_22
	j	.L8_20
.L8_20:
	lui	t4, %hi(chunks)
	lw	t5, %lo(chunks)(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	sw	t4, 24(sp)
	lw	t4, 24(sp)
	lw	t4, 0(t4)
	lui	t4, %hi(chunks)
	lw	t4, %lo(chunks)(t4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	addi	t4, t4, -3
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t6, 0(t4)
	lui	t4, %hi(chunks)
	lw	t5, %lo(chunks)(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	addi	t4, t4, -8
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	xor	t6, t6, t4
	lui	t4, %hi(chunks)
	lw	t4, %lo(chunks)(t4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	addi	t5, t5, -14
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	xor	t5, t6, t4
	lui	t4, %hi(chunks)
	lw	t6, %lo(chunks)(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t6, 0(t4)
	lw	t4, 0(s3)
	addi	t4, t4, -16
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	xor	a0, t5, t4
	addi	a1, zero, 1
	call	rotate_left
	lw	t4, 24(sp)
	sw	a0, 0(t4)
	j	.L8_21
.L8_21:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L8_19
.L8_22:
	lw	t4, 0(s6)
	sw	t4, 0(s1)
	lw	t4, 0(s7)
	sw	t4, 0(s11)
	lw	t4, 0(s8)
	sw	t4, 0(s4)
	lw	t4, 64(sp)
	lw	t4, 0(t4)
	sw	t4, 0(s0)
	lw	t5, 0(s9)
	lw	t4, 68(sp)
	sw	t5, 0(t4)
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L8_23
.L8_23:
	lw	t5, 0(s3)
	addi	t4, zero, 80
	slt	t4, t5, t4
	beqz	t4, .L8_35
	j	.L8_24
.L8_24:
	lw	t4, 0(s3)
	addi	t5, zero, 20
	slt	t4, t4, t5
	beqz	t4, .L8_26
	j	.L8_25
.L8_25:
	lw	t4, 0(s5)
	lw	t4, 0(s11)
	lw	t5, 0(s4)
	and	t4, t4, t5
	lw	t5, 0(s11)
	xori	t5, t5, -1
	lw	t6, 0(s0)
	and	t5, t5, t6
	or	t4, t4, t5
	sw	t4, 0(s5)
	lw	t4, 0(s2)
	li	t4, 1518500249
	sw	t4, 0(s2)
	j	.L8_33
.L8_26:
	lw	t4, 0(s3)
	addi	t5, zero, 40
	slt	t4, t4, t5
	beqz	t4, .L8_28
	j	.L8_27
.L8_27:
	lw	t4, 0(s5)
	lw	t4, 0(s11)
	lw	t5, 0(s4)
	xor	t4, t4, t5
	lw	t5, 0(s0)
	xor	t4, t4, t5
	sw	t4, 0(s5)
	lw	t4, 0(s2)
	li	t4, 1859775393
	sw	t4, 0(s2)
	j	.L8_32
.L8_28:
	lw	t4, 0(s3)
	addi	t5, zero, 60
	slt	t4, t4, t5
	beqz	t4, .L8_30
	j	.L8_29
.L8_29:
	lw	t4, 0(s5)
	lw	t5, 0(s11)
	lw	t4, 0(s4)
	and	t6, t5, t4
	lw	t5, 0(s11)
	lw	t4, 0(s0)
	and	t4, t5, t4
	or	t6, t6, t4
	lw	t4, 0(s4)
	lw	t5, 0(s0)
	and	t4, t4, t5
	or	t4, t6, t4
	sw	t4, 0(s5)
	lw	t4, 0(s2)
	li	a0, 48348
	li	a1, 36635
	call	lohi
	sw	a0, 0(s2)
	j	.L8_31
.L8_30:
	lw	t4, 0(s5)
	lw	t5, 0(s11)
	lw	t4, 0(s4)
	xor	t4, t5, t4
	lw	t5, 0(s0)
	xor	t4, t4, t5
	sw	t4, 0(s5)
	lw	t4, 0(s2)
	li	a0, 49622
	li	a1, 51810
	call	lohi
	sw	a0, 0(s2)
	j	.L8_31
.L8_31:
	j	.L8_32
.L8_32:
	j	.L8_33
.L8_33:
	lw	a0, 0(s1)
	addi	a1, zero, 5
	call	rotate_left
	lw	t4, 68(sp)
	lw	a1, 0(t4)
	call	add
	sw	a0, 12(sp)
	lw	a0, 0(s5)
	lw	a1, 0(s2)
	call	add
	mv	a1, a0
	lw	a0, 12(sp)
	call	add
	lui	t4, %hi(chunks)
	lw	t4, %lo(chunks)(t4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	a1, 0(t4)
	call	add
	sw	a0, 44(sp)
	lw	t4, 68(sp)
	lw	t4, 0(t4)
	lw	t5, 0(s0)
	lw	t4, 68(sp)
	sw	t5, 0(t4)
	lw	t4, 0(s0)
	lw	t4, 0(s4)
	sw	t4, 0(s0)
	lw	t4, 0(s4)
	lw	a0, 0(s11)
	addi	a1, zero, 30
	call	rotate_left
	sw	a0, 0(s4)
	lw	t4, 0(s11)
	lw	t4, 0(s1)
	sw	t4, 0(s11)
	lw	t4, 0(s1)
	lw	t4, 44(sp)
	sw	t4, 0(s1)
	j	.L8_34
.L8_34:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L8_23
.L8_35:
	lw	t4, 0(s6)
	lw	a0, 0(s6)
	lw	a1, 0(s1)
	call	add
	sw	a0, 0(s6)
	lw	t4, 0(s7)
	lw	a0, 0(s7)
	lw	a1, 0(s11)
	call	add
	sw	a0, 0(s7)
	lw	t4, 0(s8)
	lw	a0, 0(s8)
	lw	a1, 0(s4)
	call	add
	sw	a0, 0(s8)
	lw	t4, 64(sp)
	lw	t4, 0(t4)
	lw	t4, 64(sp)
	lw	a0, 0(t4)
	lw	a1, 0(s0)
	call	add
	lw	t4, 64(sp)
	sw	a0, 0(t4)
	lw	t4, 0(s9)
	lw	a0, 0(s9)
	lw	t4, 68(sp)
	lw	a1, 0(t4)
	call	add
	sw	a0, 0(s9)
	j	.L8_36
.L8_36:
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L8_17
.L8_37:
	lui	t4, %hi(outputBuffer)
	lw	t4, %lo(outputBuffer)(t4)
	addi	t5, t4, 0
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lui	t4, %hi(outputBuffer)
	lw	t4, %lo(outputBuffer)(t4)
	addi	t5, t4, 4
	lw	t4, 0(t5)
	lw	t4, 0(s7)
	sw	t4, 0(t5)
	lui	t4, %hi(outputBuffer)
	lw	t4, %lo(outputBuffer)(t4)
	addi	t4, t4, 8
	lw	t5, 0(t4)
	lw	t5, 0(s8)
	sw	t5, 0(t4)
	lui	t4, %hi(outputBuffer)
	lw	t4, %lo(outputBuffer)(t4)
	addi	t5, t4, 12
	lw	t4, 0(t5)
	lw	t4, 64(sp)
	lw	t4, 0(t4)
	sw	t4, 0(t5)
	lui	t4, %hi(outputBuffer)
	lw	t4, %lo(outputBuffer)(t4)
	addi	t4, t4, 16
	lw	t5, 0(t4)
	lw	t5, 0(s9)
	sw	t5, 0(t4)
	lui	t4, %hi(outputBuffer)
	lw	t5, %lo(outputBuffer)(t4)
	lw	t4, 36(sp)
	sw	t5, 0(t4)
	j	.L8_39
.L8_38:
	j	.L8_39
.L8_39:
	lw	t4, 36(sp)
	lw	a0, 0(t4)
	lw	s11, 16(sp)
	lw	s10, 28(sp)
	lw	s0, 84(sp)
	lw	s1, 60(sp)
	lw	s2, 72(sp)
	lw	s3, 40(sp)
	lw	s4, 48(sp)
	lw	s5, 4(sp)
	lw	s6, 56(sp)
	lw	s7, 8(sp)
	lw	s8, 32(sp)
	lw	s9, 80(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 88
	ret
	.size	sha1, .-sha1
	.globl	int2chr
	.p2align	2
	.type	int2chr,@function
int2chr:
.L9_0:
	addi	sp, sp, -16
	sw	ra, 4(sp)
	sw	s0, 8(sp)
	sw	s4, 12(sp)
	sw	s8, 0(sp)
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	t4, zero, 32
	slt	t4, s0, t4
	xori	t4, t4, 1
	beqz	t4, .L9_2
	j	.L9_3
.L9_1:
	addi	t4, zero, 0
	j	.L9_4
.L9_2:
	addi	t4, zero, 0
	j	.L9_4
.L9_3:
	addi	t4, zero, 126
	slt	t4, t4, s0
	xori	t4, t4, 1
	j	.L9_4
.L9_4:
	beqz	t4, .L9_7
	j	.L9_5
.L9_5:
	lui	t4, %hi(asciiTable)
	lw	a0, %lo(asciiTable)(t4)
	addi	a1, s0, -32
	addi	a2, s0, -31
	call	mx__string_substring
	sw	a0, 0(s4)
	j	.L9_10
.L9_6:
	j	.L9_8
.L9_7:
	j	.L9_8
.L9_8:
	la	t4, .str.1
	sw	t4, 0(s4)
	j	.L9_10
.L9_9:
	j	.L9_10
.L9_10:
	lw	a0, 0(s4)
	lw	s0, 8(sp)
	lw	s4, 12(sp)
	lw	s8, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
	.size	int2chr, .-int2chr
	.globl	array_equal
	.p2align	2
	.type	array_equal,@function
array_equal:
.L10_0:
	addi	sp, sp, -20
	sw	ra, 4(sp)
	sw	s0, 8(sp)
	sw	s2, 12(sp)
	sw	s3, 16(sp)
	sw	s4, 0(sp)
	mv	s2, a0
	mv	s0, a1
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	a0, zero, 1
	call	malloc
	mv	t4, s2
	addi	t4, t4, -4
	lw	t5, 0(t4)
	mv	t4, s0
	addi	t4, t4, -4
	lw	t4, 0(t4)
	sub	t4, t5, t4
	snez	t4, t4
	beqz	t4, .L10_3
	j	.L10_1
.L10_1:
	sb	zero, 0(a0)
	j	.L10_14
.L10_2:
	j	.L10_4
.L10_3:
	j	.L10_4
.L10_4:
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	j	.L10_5
.L10_5:
	lw	t5, 0(s3)
	mv	t4, s2
	addi	t4, t4, -4
	lw	t4, 0(t4)
	slt	t4, t5, t4
	beqz	t4, .L10_12
	j	.L10_6
.L10_6:
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, s2, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, s0, t4
	lw	t4, 0(t4)
	sub	t4, t5, t4
	snez	t4, t4
	beqz	t4, .L10_9
	j	.L10_7
.L10_7:
	sb	zero, 0(a0)
	j	.L10_14
.L10_8:
	j	.L10_10
.L10_9:
	j	.L10_10
.L10_10:
	j	.L10_11
.L10_11:
	lw	t4, 0(s3)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	j	.L10_5
.L10_12:
	addi	t4, zero, 1
	sb	t4, 0(a0)
	j	.L10_14
.L10_13:
	j	.L10_14
.L10_14:
	lb	a0, 0(a0)
	lw	s0, 8(sp)
	lw	s2, 12(sp)
	lw	s3, 16(sp)
	lw	s4, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 20
	ret
	.size	array_equal, .-array_equal
	.globl	rotate_left
	.p2align	2
	.type	rotate_left,@function
rotate_left:
.L11_0:
	addi	sp, sp, -12
	sw	ra, 8(sp)
	sw	s10, 0(sp)
	sw	s0, 4(sp)
	mv	s10, a0
	mv	s0, a1
	addi	a0, zero, 4
	call	malloc
	addi	t4, s0, -1
	seqz	t4, t4
	beqz	t4, .L11_3
	j	.L11_1
.L11_1:
	li	t4, 2147483647
	and	t4, s10, t4
	slli	t4, t4, 1
	srai	t5, s10, 31
	andi	t5, t5, 1
	or	t4, t4, t5
	sw	t4, 0(a0)
	j	.L11_10
.L11_2:
	j	.L11_4
.L11_3:
	j	.L11_4
.L11_4:
	addi	t4, s0, -31
	seqz	t4, t4
	beqz	t4, .L11_7
	j	.L11_5
.L11_5:
	andi	t4, s10, 1
	slli	t6, t4, 31
	srai	t5, s10, 1
	li	t4, 2147483647
	and	t4, t5, t4
	or	t4, t6, t4
	sw	t4, 0(a0)
	j	.L11_10
.L11_6:
	j	.L11_8
.L11_7:
	j	.L11_8
.L11_8:
	addi	t4, zero, 32
	sub	t5, t4, s0
	addi	t4, zero, 1
	sll	t4, t4, t5
	addi	t4, t4, -1
	and	t4, s10, t4
	sll	t6, t4, s0
	addi	t4, zero, 32
	sub	t4, t4, s0
	sra	t4, s10, t4
	addi	t5, zero, 1
	sll	t5, t5, s0
	addi	t5, t5, -1
	and	t4, t4, t5
	or	t4, t6, t4
	sw	t4, 0(a0)
	j	.L11_10
.L11_9:
	j	.L11_10
.L11_10:
	lw	a0, 0(a0)
	lw	s10, 0(sp)
	lw	s0, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 12
	ret
	.size	rotate_left, .-rotate_left
	.globl	lohi
	.p2align	2
	.type	lohi,@function
lohi:
.L12_0:
	slli	t4, a1, 16
	or	a0, a0, t4
	j	.L12_2
.L12_1:
	j	.L12_2
.L12_2:
	ret
	.size	lohi, .-lohi
	.globl	nextLetter
	.p2align	2
	.type	nextLetter,@function
nextLetter:
.L13_0:
	addi	sp, sp, -8
	sw	ra, 0(sp)
	sw	s0, 4(sp)
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	addi	t4, s0, -122
	seqz	t4, t4
	beqz	t4, .L13_3
	j	.L13_1
.L13_1:
	addi	t4, zero, -1
	sw	t4, 0(a0)
	j	.L13_14
.L13_2:
	j	.L13_4
.L13_3:
	j	.L13_4
.L13_4:
	addi	t4, s0, -90
	seqz	t4, t4
	beqz	t4, .L13_7
	j	.L13_5
.L13_5:
	addi	t4, zero, 97
	sw	t4, 0(a0)
	j	.L13_14
.L13_6:
	j	.L13_8
.L13_7:
	j	.L13_8
.L13_8:
	addi	t4, s0, -57
	seqz	t4, t4
	beqz	t4, .L13_11
	j	.L13_9
.L13_9:
	addi	t4, zero, 65
	sw	t4, 0(a0)
	j	.L13_14
.L13_10:
	j	.L13_12
.L13_11:
	j	.L13_12
.L13_12:
	addi	t4, s0, 1
	sw	t4, 0(a0)
	j	.L13_14
.L13_13:
	j	.L13_14
.L13_14:
	lw	a0, 0(a0)
	lw	s0, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 8
	ret
	.size	nextLetter, .-nextLetter

	.section	.sdata,"aw",@progbits
	.global	outputBuffer
	.p2align	2
	outputBuffer:
	.word	0                       # 0
	.str.4:
	.asciz	"Not Found! "
	.str.3:
	.asciz	"Invalid input "
	.global	asciiTable
	.p2align	2
	asciiTable:
	.word	0                       # 0
	.global	inputBuffer
	.p2align	2
	inputBuffer:
	.word	0                       # 0
	.global	MAXCHUNK
	.p2align	2
	MAXCHUNK:
	.word	100                     # 100
	.global	chunks
	.p2align	2
	chunks:
	.word	0                       # 0
	.str.0:
	.asciz	" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ "
	.global	MAXLENGTH
	.p2align	2
	MAXLENGTH:
	.word	0                       # 0
	.str.2:
	.asciz	"nChunk > MAXCHUNK! "
	.str.1:
	.asciz	" "
