	.text

	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L0_0:
	addi	sp, sp, -20
	sw	ra, 12(sp)
	sw	s7, 16(sp)
	sw	s8, 0(sp)
	sw	s9, 4(sp)
	sw	s10, 8(sp)
	la	t0, .str.0
	lui	ra, %hi(asciiTable)
	sw	t0, %lo(asciiTable)(ra)
	lui	ra, %hi(MAXCHUNK)
	lw	ra, %lo(MAXCHUNK)(ra)
	addi	t0, ra, -1
	addi	ra, zero, 64
	mul	ra, t0, ra
	addi	t0, ra, -16
	lui	ra, %hi(MAXLENGTH)
	sw	t0, %lo(MAXLENGTH)(ra)
	lui	ra, %hi(MAXCHUNK)
	lw	s8, %lo(MAXCHUNK)(ra)
	addi	ra, zero, 4
	mul	ra, s8, ra
	addi	a0, ra, 4
	call	malloc
	sw	s8, 0(a0)
	addi	ra, a0, 4
	mv	s7, ra
	slli	ra, s8, 2
	add	s8, s7, ra
	mv	s9, s7
	j	.L0_1
.L0_1:
	sub	ra, s9, s8
	snez	ra, ra
	beqz	ra, .L0_3
	j	.L0_2
.L0_2:
	addi	a0, zero, 324
	call	malloc
	addi	ra, zero, 80
	sw	ra, 0(a0)
	addi	ra, a0, 4
	sw	ra, 0(s9)
	addi	ra, s9, 4
	mv	s9, ra
	j	.L0_1
.L0_3:
	lui	ra, %hi(chunks)
	sw	s7, %lo(chunks)(ra)
	lui	ra, %hi(MAXLENGTH)
	lw	s7, %lo(MAXLENGTH)(ra)
	addi	ra, zero, 4
	mul	ra, s7, ra
	addi	a0, ra, 4
	call	malloc
	sw	s7, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(inputBuffer)
	sw	ra, %lo(inputBuffer)(t0)
	addi	a0, zero, 24
	call	malloc
	addi	ra, zero, 5
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(outputBuffer)
	sw	ra, %lo(outputBuffer)(t0)
	j	.L0_4
.L0_4:
	lw	s7, 16(sp)
	lw	s8, 0(sp)
	lw	s9, 4(sp)
	lw	s10, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 20
	ret
	.size	mx__init, .-mx__init
	.globl	hex2int
	.p2align	2
	.type	hex2int,@function
hex2int:
.L1_0:
	addi	sp, sp, -20
	sw	ra, 12(sp)
	sw	s7, 16(sp)
	sw	s8, 0(sp)
	sw	s9, 4(sp)
	sw	s10, 8(sp)
	mv	s7, a0
	addi	s8, zero, 0
	addi	s9, zero, 0
	j	.L1_1
.L1_1:
	mv	a0, s7
	call	mx__string_length
	slt	ra, s9, a0
	beqz	ra, .L1_22
	j	.L1_2
.L1_2:
	mv	a0, s7
	mv	a1, s9
	call	mx__string_ord
	addi	ra, zero, 48
	slt	ra, a0, ra
	xori	ra, ra, 1
	beqz	ra, .L1_3
	j	.L1_4
.L1_3:
	addi	ra, zero, 0
	j	.L1_5
.L1_4:
	addi	ra, zero, 57
	slt	ra, ra, a0
	xori	ra, ra, 1
	j	.L1_5
.L1_5:
	beqz	ra, .L1_7
	j	.L1_6
.L1_6:
	addi	ra, zero, 16
	mul	ra, s8, ra
	add	ra, ra, a0
	addi	t0, ra, -48
	j	.L1_20
.L1_7:
	addi	ra, zero, 65
	slt	ra, a0, ra
	xori	ra, ra, 1
	beqz	ra, .L1_8
	j	.L1_9
.L1_8:
	addi	ra, zero, 0
	j	.L1_10
.L1_9:
	addi	ra, zero, 70
	slt	ra, ra, a0
	xori	ra, ra, 1
	j	.L1_10
.L1_10:
	beqz	ra, .L1_12
	j	.L1_11
.L1_11:
	addi	ra, zero, 16
	mul	ra, s8, ra
	add	ra, ra, a0
	addi	ra, ra, -65
	addi	t0, ra, 10
	j	.L1_19
.L1_12:
	addi	ra, zero, 97
	slt	ra, a0, ra
	xori	ra, ra, 1
	beqz	ra, .L1_13
	j	.L1_14
.L1_13:
	addi	ra, zero, 0
	j	.L1_15
.L1_14:
	addi	ra, zero, 102
	slt	ra, ra, a0
	xori	ra, ra, 1
	j	.L1_15
.L1_15:
	beqz	ra, .L1_17
	j	.L1_16
.L1_16:
	addi	ra, zero, 16
	mul	ra, s8, ra
	add	ra, ra, a0
	addi	ra, ra, -97
	addi	t0, ra, 10
	j	.L1_18
.L1_17:
	addi	a0, zero, 0
	j	.L1_23
.L1_18:
	j	.L1_19
.L1_19:
	j	.L1_20
.L1_20:
	j	.L1_21
.L1_21:
	addi	ra, s9, 1
	mv	s8, t0
	mv	s9, ra
	j	.L1_1
.L1_22:
	mv	a0, s8
	j	.L1_23
.L1_23:
	lw	s7, 16(sp)
	lw	s8, 0(sp)
	lw	s9, 4(sp)
	lw	s10, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 20
	ret
	.size	hex2int, .-hex2int
	.globl	int2chr
	.p2align	2
	.type	int2chr,@function
int2chr:
.L2_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	ra, zero, 32
	slt	ra, a0, ra
	xori	ra, ra, 1
	beqz	ra, .L2_1
	j	.L2_2
.L2_1:
	addi	ra, zero, 0
	j	.L2_3
.L2_2:
	addi	ra, zero, 126
	slt	ra, ra, a0
	xori	ra, ra, 1
	j	.L2_3
.L2_3:
	beqz	ra, .L2_5
	j	.L2_4
.L2_4:
	lui	ra, %hi(asciiTable)
	lw	ra, %lo(asciiTable)(ra)
	addi	a1, a0, -32
	addi	a2, a0, -31
	mv	a0, ra
	call	mx__string_substring
	j	.L2_7
.L2_5:
	j	.L2_6
.L2_6:
	la	a0, .str.1
	j	.L2_7
.L2_7:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	int2chr, .-int2chr
	.globl	toStringHex
	.p2align	2
	.type	toStringHex,@function
toStringHex:
.L3_0:
	addi	sp, sp, -20
	sw	ra, 12(sp)
	sw	s7, 16(sp)
	sw	s8, 0(sp)
	sw	s9, 4(sp)
	sw	s10, 8(sp)
	mv	s7, a0
	la	ra, .str.1
	mv	s8, ra
	addi	s9, zero, 28
	j	.L3_1
.L3_1:
	slt	ra, s9, zero
	xori	ra, ra, 1
	beqz	ra, .L3_7
	j	.L3_2
.L3_2:
	sra	ra, s7, s9
	andi	t0, ra, 15
	addi	ra, zero, 10
	slt	ra, t0, ra
	beqz	ra, .L3_4
	j	.L3_3
.L3_3:
	addi	a0, t0, 48
	call	int2chr
	mv	a1, a0
	mv	a0, s8
	call	mx__string_add
	j	.L3_5
.L3_4:
	addi	ra, t0, 65
	addi	a0, ra, -10
	call	int2chr
	mv	a1, a0
	mv	a0, s8
	call	mx__string_add
	j	.L3_5
.L3_5:
	j	.L3_6
.L3_6:
	addi	ra, s9, -4
	mv	s8, a0
	mv	s9, ra
	j	.L3_1
.L3_7:
	j	.L3_8
.L3_8:
	mv	a0, s8
	lw	s7, 16(sp)
	lw	s8, 0(sp)
	lw	s9, 4(sp)
	lw	s10, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 20
	ret
	.size	toStringHex, .-toStringHex
	.globl	rotate_left
	.p2align	2
	.type	rotate_left,@function
rotate_left:
.L4_0:
	addi	t0, a1, -1
	seqz	t0, t0
	beqz	t0, .L4_2
	j	.L4_1
.L4_1:
	li	t0, 2147483647
	and	t0, a0, t0
	slli	t1, t0, 1
	srai	t0, a0, 31
	andi	t0, t0, 1
	or	a0, t1, t0
	j	.L4_7
.L4_2:
	j	.L4_3
.L4_3:
	addi	t0, a1, -31
	seqz	t0, t0
	beqz	t0, .L4_5
	j	.L4_4
.L4_4:
	andi	t0, a0, 1
	slli	t2, t0, 31
	srai	t1, a0, 1
	li	t0, 2147483647
	and	t0, t1, t0
	or	a0, t2, t0
	j	.L4_7
.L4_5:
	j	.L4_6
.L4_6:
	addi	t0, zero, 32
	sub	t1, t0, a1
	addi	t0, zero, 1
	sll	t0, t0, t1
	addi	t0, t0, -1
	and	t0, a0, t0
	sll	t2, t0, a1
	addi	t0, zero, 32
	sub	t0, t0, a1
	sra	t1, a0, t0
	addi	t0, zero, 1
	sll	t0, t0, a1
	addi	t0, t0, -1
	and	t0, t1, t0
	or	a0, t2, t0
	j	.L4_7
.L4_7:
	ret
	.size	rotate_left, .-rotate_left
	.globl	add
	.p2align	2
	.type	add,@function
add:
.L5_0:
	li	t0, 65535
	and	t1, a0, t0
	li	t0, 65535
	and	t0, a1, t0
	add	t0, t1, t0
	srai	t2, a0, 16
	li	t1, 65535
	and	a0, t2, t1
	srai	t2, a1, 16
	li	t1, 65535
	and	t1, t2, t1
	add	t2, a0, t1
	srai	t1, t0, 16
	add	t2, t2, t1
	li	t1, 65535
	and	t1, t2, t1
	slli	t2, t1, 16
	li	t1, 65535
	and	t0, t0, t1
	or	a0, t2, t0
	j	.L5_1
.L5_1:
	ret
	.size	add, .-add
	.globl	lohi
	.p2align	2
	.type	lohi,@function
lohi:
.L6_0:
	slli	t0, a1, 16
	or	a0, a0, t0
	j	.L6_1
.L6_1:
	ret
	.size	lohi, .-lohi
	.globl	sha1
	.p2align	2
	.type	sha1,@function
sha1:
.L7_0:
	addi	sp, sp, -104
	sw	ra, 100(sp)
	sw	s0, 52(sp)
	sw	s1, 56(sp)
	sw	s2, 60(sp)
	sw	s3, 64(sp)
	sw	s4, 68(sp)
	sw	s5, 72(sp)
	sw	s6, 76(sp)
	sw	s7, 80(sp)
	sw	s8, 84(sp)
	sw	s9, 88(sp)
	sw	s10, 92(sp)
	sw	s11, 96(sp)
	addi	ra, a1, 64
	addi	t0, ra, -56
	addi	ra, zero, 64
	div	ra, t0, ra
	addi	s4, ra, 1
	lui	ra, %hi(MAXCHUNK)
	lw	ra, %lo(MAXCHUNK)(ra)
	slt	ra, ra, s4
	beqz	ra, .L7_2
	j	.L7_1
.L7_1:
	la	a0, .str.2
	call	mx__println
	addi	a1, zero, 0
	addi	a1, zero, 0
	addi	a2, zero, 0
	addi	t2, zero, 0
	addi	t1, zero, 0
	addi	t0, zero, 0
	addi	ra, zero, 0
	addi	ra, zero, 0
	addi	ra, zero, 0
	addi	ra, zero, 0
	addi	ra, zero, 0
	addi	ra, zero, 0
	addi	s0, zero, 0
	addi	ra, zero, 0
	mv	a0, zero
	j	.L7_37
.L7_2:
	j	.L7_3
.L7_3:
	addi	ra, zero, 0
	addi	s0, zero, 0
	j	.L7_4
.L7_4:
	slt	t0, ra, s4
	beqz	t0, .L7_11
	j	.L7_5
.L7_5:
	addi	s0, zero, 0
	j	.L7_6
.L7_6:
	addi	t0, zero, 80
	slt	t0, s0, t0
	beqz	t0, .L7_9
	j	.L7_7
.L7_7:
	lui	t0, %hi(chunks)
	lw	t1, %lo(chunks)(t0)
	slli	t0, ra, 2
	add	t0, t1, t0
	lw	t1, 0(t0)
	slli	t0, s0, 2
	add	t0, t1, t0
	sw	zero, 0(t0)
	j	.L7_8
.L7_8:
	addi	s0, s0, 1
	j	.L7_6
.L7_9:
	j	.L7_10
.L7_10:
	addi	ra, ra, 1
	j	.L7_4
.L7_11:
	addi	ra, zero, 0
	j	.L7_12
.L7_12:
	slt	t0, ra, a1
	beqz	t0, .L7_15
	j	.L7_13
.L7_13:
	lui	t0, %hi(chunks)
	lw	t1, %lo(chunks)(t0)
	addi	t0, zero, 64
	div	t0, ra, t0
	slli	t0, t0, 2
	add	t0, t1, t0
	lw	t2, 0(t0)
	addi	t0, zero, 64
	rem	t1, ra, t0
	addi	t0, zero, 4
	div	t0, t1, t0
	slli	t0, t0, 2
	add	t0, t2, t0
	lui	t1, %hi(chunks)
	lw	t2, %lo(chunks)(t1)
	addi	t1, zero, 64
	div	t1, ra, t1
	slli	t1, t1, 2
	add	t1, t2, t1
	lw	a2, 0(t1)
	addi	t1, zero, 64
	rem	t2, ra, t1
	addi	t1, zero, 4
	div	t1, t2, t1
	slli	t1, t1, 2
	add	t1, a2, t1
	lw	a3, 0(t1)
	slli	t1, ra, 2
	add	t1, a0, t1
	lw	a2, 0(t1)
	addi	t1, zero, 4
	rem	t2, ra, t1
	addi	t1, zero, 3
	sub	t2, t1, t2
	addi	t1, zero, 8
	mul	t1, t2, t1
	sll	t1, a2, t1
	or	t1, a3, t1
	sw	t1, 0(t0)
	j	.L7_14
.L7_14:
	addi	ra, ra, 1
	j	.L7_12
.L7_15:
	lui	t0, %hi(chunks)
	lw	t1, %lo(chunks)(t0)
	addi	t0, zero, 64
	div	t0, ra, t0
	slli	t0, t0, 2
	add	t0, t1, t0
	lw	t2, 0(t0)
	addi	t0, zero, 64
	rem	t1, ra, t0
	addi	t0, zero, 4
	div	t0, t1, t0
	slli	t0, t0, 2
	add	t0, t2, t0
	lui	t1, %hi(chunks)
	lw	t2, %lo(chunks)(t1)
	addi	t1, zero, 64
	div	t1, ra, t1
	slli	t1, t1, 2
	add	t1, t2, t1
	lw	a0, 0(t1)
	addi	t1, zero, 64
	rem	t2, ra, t1
	addi	t1, zero, 4
	div	t1, t2, t1
	slli	t1, t1, 2
	add	t1, a0, t1
	lw	t2, 0(t1)
	addi	t1, zero, 4
	rem	t1, ra, t1
	addi	ra, zero, 3
	sub	t1, ra, t1
	addi	ra, zero, 8
	mul	t1, t1, ra
	addi	ra, zero, 128
	sll	ra, ra, t1
	or	ra, t2, ra
	sw	ra, 0(t0)
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	addi	ra, s4, -1
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	t0, ra, 60
	slli	ra, a1, 3
	sw	ra, 0(t0)
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	addi	ra, s4, -1
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	t0, ra, 56
	srai	ra, a1, 29
	andi	ra, ra, 7
	sw	ra, 0(t0)
	li	a0, 43913
	li	a1, 61389
	call	lohi
	mv	s1, a0
	li	a0, 56574
	li	a1, 39098
	call	lohi
	mv	s2, a0
	li	a0, 57840
	li	a1, 50130
	call	lohi
	addi	ra, zero, 0
	sw	ra, 4(sp)
	addi	ra, zero, 0
	sw	ra, 12(sp)
	addi	s9, zero, 0
	mv	s5, a0
	li	ra, 271733878
	mv	s6, ra
	mv	s7, s2
	mv	s8, s1
	li	ra, 1732584193
	mv	s10, ra
	addi	a2, zero, 0
	addi	t2, zero, 0
	addi	t1, zero, 0
	addi	t0, zero, 0
	addi	ra, zero, 0
	j	.L7_16
.L7_16:
	slt	a0, s9, s4
	beqz	a0, .L7_36
	j	.L7_17
.L7_17:
	addi	s0, zero, 16
	j	.L7_18
.L7_18:
	addi	ra, zero, 80
	slt	ra, s0, ra
	beqz	ra, .L7_21
	j	.L7_19
.L7_19:
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s0, 2
	add	s1, t0, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s0, -3
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	t1, 0(ra)
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s0, -8
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	t1, t1, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s0, -14
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	t1, t1, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s0, -16
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	a0, t1, ra
	addi	a1, zero, 1
	call	rotate_left
	sw	a0, 0(s1)
	j	.L7_20
.L7_20:
	addi	s0, s0, 1
	j	.L7_18
.L7_21:
	addi	s0, zero, 0
	mv	s11, s10
	mv	s1, s8
	mv	s2, s7
	mv	s3, s6
	mv	ra, s5
	sw	ra, 0(sp)
	lw	ra, 4(sp)
	sw	ra, 24(sp)
	lw	ra, 12(sp)
	sw	ra, 20(sp)
	j	.L7_22
.L7_22:
	addi	ra, zero, 80
	slt	ra, s0, ra
	beqz	ra, .L7_34
	j	.L7_23
.L7_23:
	addi	ra, zero, 20
	slt	ra, s0, ra
	beqz	ra, .L7_25
	j	.L7_24
.L7_24:
	and	t0, s1, s2
	xori	ra, s1, -1
	and	ra, ra, s3
	or	t0, t0, ra
	li	ra, 1518500249
	sw	ra, 8(sp)
	sw	t0, 16(sp)
	j	.L7_32
.L7_25:
	addi	ra, zero, 40
	slt	ra, s0, ra
	beqz	ra, .L7_27
	j	.L7_26
.L7_26:
	xor	ra, s1, s2
	xor	ra, ra, s3
	li	a0, 1859775393
	j	.L7_31
.L7_27:
	addi	ra, zero, 60
	slt	ra, s0, ra
	beqz	ra, .L7_29
	j	.L7_28
.L7_28:
	and	t0, s1, s2
	and	ra, s1, s3
	or	t0, t0, ra
	and	ra, s2, s3
	or	ra, t0, ra
	sw	ra, 28(sp)
	li	a0, 48348
	li	a1, 36635
	call	lohi
	lw	ra, 28(sp)
	j	.L7_30
.L7_29:
	xor	ra, s1, s2
	xor	ra, ra, s3
	sw	ra, 32(sp)
	li	a0, 49622
	li	a1, 51810
	call	lohi
	lw	ra, 32(sp)
	j	.L7_30
.L7_30:
	j	.L7_31
.L7_31:
	sw	a0, 8(sp)
	sw	ra, 16(sp)
	j	.L7_32
.L7_32:
	mv	a0, s11
	addi	a1, zero, 5
	call	rotate_left
	lw	a1, 0(sp)
	call	add
	sw	a0, 36(sp)
	lw	a0, 16(sp)
	lw	a1, 8(sp)
	call	add
	mv	a1, a0
	lw	a0, 36(sp)
	call	add
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s0, 2
	add	ra, t0, ra
	lw	a1, 0(ra)
	call	add
	sw	a0, 40(sp)
	mv	a0, s1
	addi	a1, zero, 30
	call	rotate_left
	j	.L7_33
.L7_33:
	addi	ra, s0, 1
	mv	s0, ra
	mv	s1, s11
	lw	ra, 40(sp)
	mv	s11, ra
	mv	ra, s3
	sw	ra, 0(sp)
	mv	s3, s2
	mv	s2, a0
	lw	ra, 8(sp)
	sw	ra, 24(sp)
	lw	ra, 16(sp)
	sw	ra, 20(sp)
	j	.L7_22
.L7_34:
	mv	a0, s10
	mv	a1, s11
	call	add
	sw	a0, 48(sp)
	mv	a0, s8
	mv	a1, s1
	call	add
	sw	a0, 44(sp)
	mv	a0, s7
	mv	a1, s2
	call	add
	mv	s7, a0
	mv	a0, s6
	mv	a1, s3
	call	add
	mv	s6, a0
	mv	a0, s5
	lw	a1, 0(sp)
	call	add
	j	.L7_35
.L7_35:
	addi	ra, s9, 1
	lw	t0, 24(sp)
	sw	t0, 4(sp)
	lw	t0, 20(sp)
	sw	t0, 12(sp)
	mv	s9, ra
	mv	s5, a0
	lw	ra, 44(sp)
	mv	s8, ra
	lw	ra, 48(sp)
	mv	s10, ra
	lw	a2, 0(sp)
	mv	t2, s3
	mv	t1, s2
	mv	t0, s1
	mv	ra, s11
	j	.L7_16
.L7_36:
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	addi	a0, a0, 0
	sw	s10, 0(a0)
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	addi	a0, a0, 4
	sw	s8, 0(a0)
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	addi	a0, a0, 8
	sw	s7, 0(a0)
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	addi	a0, a0, 12
	sw	s6, 0(a0)
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	addi	a0, a0, 16
	sw	s5, 0(a0)
	lui	a0, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(a0)
	lw	a1, 4(sp)
	lw	a1, 12(sp)
	mv	ra, s5
	mv	ra, s6
	mv	ra, s7
	mv	ra, s8
	mv	ra, s10
	mv	ra, s9
	j	.L7_37
.L7_37:
	lw	s0, 52(sp)
	lw	s1, 56(sp)
	lw	s2, 60(sp)
	lw	s3, 64(sp)
	lw	s4, 68(sp)
	lw	s5, 72(sp)
	lw	s6, 76(sp)
	lw	s7, 80(sp)
	lw	s8, 84(sp)
	lw	s9, 88(sp)
	lw	s10, 92(sp)
	lw	s11, 96(sp)
	lw	ra, 100(sp)
	addi	sp, sp, 104
	ret
	.size	sha1, .-sha1
	.globl	computeSHA1
	.p2align	2
	.type	computeSHA1,@function
computeSHA1:
.L8_0:
	addi	sp, sp, -20
	sw	ra, 12(sp)
	sw	s7, 16(sp)
	sw	s8, 0(sp)
	sw	s9, 4(sp)
	sw	s10, 8(sp)
	mv	s8, a0
	addi	s9, zero, 0
	j	.L8_1
.L8_1:
	mv	a0, s8
	call	mx__string_length
	slt	ra, s9, a0
	beqz	ra, .L8_4
	j	.L8_2
.L8_2:
	lui	ra, %hi(inputBuffer)
	lw	t0, %lo(inputBuffer)(ra)
	slli	ra, s9, 2
	add	s7, t0, ra
	mv	a0, s8
	mv	a1, s9
	call	mx__string_ord
	sw	a0, 0(s7)
	j	.L8_3
.L8_3:
	addi	ra, s9, 1
	mv	s9, ra
	j	.L8_1
.L8_4:
	lui	ra, %hi(inputBuffer)
	lw	s7, %lo(inputBuffer)(ra)
	mv	a0, s8
	call	mx__string_length
	mv	a1, a0
	mv	a0, s7
	call	sha1
	mv	s8, a0
	addi	s7, zero, 0
	j	.L8_5
.L8_5:
	addi	ra, s8, -4
	lw	ra, 0(ra)
	slt	ra, s7, ra
	beqz	ra, .L8_8
	j	.L8_6
.L8_6:
	slli	ra, s7, 2
	add	ra, s8, ra
	lw	a0, 0(ra)
	call	toStringHex
	call	mx__print
	j	.L8_7
.L8_7:
	addi	s7, s7, 1
	j	.L8_5
.L8_8:
	la	a0, .str.1
	call	mx__println
	j	.L8_9
.L8_9:
	lw	s7, 16(sp)
	lw	s8, 0(sp)
	lw	s9, 4(sp)
	lw	s10, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 20
	ret
	.size	computeSHA1, .-computeSHA1
	.globl	nextLetter
	.p2align	2
	.type	nextLetter,@function
nextLetter:
.L9_0:
	addi	t0, a0, -122
	seqz	t0, t0
	beqz	t0, .L9_2
	j	.L9_1
.L9_1:
	addi	a0, zero, -1
	j	.L9_10
.L9_2:
	j	.L9_3
.L9_3:
	addi	t0, a0, -90
	seqz	t0, t0
	beqz	t0, .L9_5
	j	.L9_4
.L9_4:
	addi	a0, zero, 97
	j	.L9_10
.L9_5:
	j	.L9_6
.L9_6:
	addi	t0, a0, -57
	seqz	t0, t0
	beqz	t0, .L9_8
	j	.L9_7
.L9_7:
	addi	a0, zero, 65
	j	.L9_10
.L9_8:
	j	.L9_9
.L9_9:
	addi	a0, a0, 1
	j	.L9_10
.L9_10:
	ret
	.size	nextLetter, .-nextLetter
	.globl	nextText
	.p2align	2
	.type	nextText,@function
nextText:
.L10_0:
	addi	sp, sp, -20
	sw	ra, 12(sp)
	sw	s7, 16(sp)
	sw	s8, 0(sp)
	sw	s9, 4(sp)
	sw	s10, 8(sp)
	mv	s8, a0
	addi	ra, a1, -1
	mv	s9, ra
	j	.L10_1
.L10_1:
	slt	ra, s9, zero
	xori	ra, ra, 1
	beqz	ra, .L10_7
	j	.L10_2
.L10_2:
	slli	ra, s9, 2
	add	s7, s8, ra
	slli	ra, s9, 2
	add	ra, s8, ra
	lw	a0, 0(ra)
	call	nextLetter
	sw	a0, 0(s7)
	slli	ra, s9, 2
	add	ra, s8, ra
	lw	ra, 0(ra)
	addi	ra, ra, 1
	seqz	ra, ra
	beqz	ra, .L10_4
	j	.L10_3
.L10_3:
	slli	ra, s9, 2
	add	t0, s8, ra
	addi	ra, zero, 48
	sw	ra, 0(t0)
	j	.L10_5
.L10_4:
	addi	a0, zero, 1
	j	.L10_8
.L10_5:
	j	.L10_6
.L10_6:
	addi	ra, s9, -1
	mv	s9, ra
	j	.L10_1
.L10_7:
	addi	a0, zero, 0
	j	.L10_8
.L10_8:
	lw	s7, 16(sp)
	lw	s8, 0(sp)
	lw	s9, 4(sp)
	lw	s10, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 20
	ret
	.size	nextText, .-nextText
	.globl	array_equal
	.p2align	2
	.type	array_equal,@function
array_equal:
.L11_0:
	addi	t0, a0, -4
	lw	t1, 0(t0)
	addi	t0, a1, -4
	lw	t0, 0(t0)
	sub	t0, t1, t0
	snez	t0, t0
	beqz	t0, .L11_2
	j	.L11_1
.L11_1:
	addi	t0, zero, 0
	addi	a0, zero, 0
	j	.L11_11
.L11_2:
	j	.L11_3
.L11_3:
	addi	t0, zero, 0
	j	.L11_4
.L11_4:
	addi	t1, a0, -4
	lw	t1, 0(t1)
	slt	t1, t0, t1
	beqz	t1, .L11_10
	j	.L11_5
.L11_5:
	slli	t1, t0, 2
	add	t1, a0, t1
	lw	t2, 0(t1)
	slli	t1, t0, 2
	add	t1, a1, t1
	lw	t1, 0(t1)
	sub	t1, t2, t1
	snez	t1, t1
	beqz	t1, .L11_7
	j	.L11_6
.L11_6:
	addi	a0, zero, 0
	j	.L11_11
.L11_7:
	j	.L11_8
.L11_8:
	j	.L11_9
.L11_9:
	addi	t0, t0, 1
	j	.L11_4
.L11_10:
	addi	a0, zero, 1
	j	.L11_11
.L11_11:
	ret
	.size	array_equal, .-array_equal
	.globl	crackSHA1
	.p2align	2
	.type	crackSHA1,@function
crackSHA1:
.L12_0:
	addi	sp, sp, -28
	sw	ra, 20(sp)
	sw	s5, 24(sp)
	sw	s6, 0(sp)
	sw	s7, 4(sp)
	sw	s8, 8(sp)
	sw	s9, 12(sp)
	sw	s10, 16(sp)
	mv	s8, a0
	addi	a0, zero, 24
	call	malloc
	addi	ra, zero, 5
	sw	ra, 0(a0)
	addi	ra, a0, 4
	mv	s9, ra
	mv	a0, s8
	call	mx__string_length
	addi	ra, a0, -40
	snez	ra, ra
	beqz	ra, .L12_2
	j	.L12_1
.L12_1:
	la	a0, .str.3
	call	mx__println
	addi	s6, zero, 0
	addi	s5, zero, 0
	j	.L12_33
.L12_2:
	j	.L12_3
.L12_3:
	addi	ra, zero, 0
	j	.L12_4
.L12_4:
	addi	t0, zero, 5
	slt	t0, ra, t0
	beqz	t0, .L12_7
	j	.L12_5
.L12_5:
	slli	t0, ra, 2
	add	t0, s9, t0
	sw	zero, 0(t0)
	j	.L12_6
.L12_6:
	addi	ra, ra, 1
	j	.L12_4
.L12_7:
	addi	s7, zero, 0
	j	.L12_8
.L12_8:
	addi	ra, zero, 40
	slt	ra, s7, ra
	beqz	ra, .L12_11
	j	.L12_9
.L12_9:
	addi	ra, zero, 8
	div	ra, s7, ra
	slli	ra, ra, 2
	add	s5, s9, ra
	addi	ra, zero, 8
	div	ra, s7, ra
	slli	ra, ra, 2
	add	ra, s9, ra
	lw	s6, 0(ra)
	addi	a2, s7, 4
	mv	a0, s8
	mv	a1, s7
	call	mx__string_substring
	call	hex2int
	addi	ra, zero, 4
	div	t0, s7, ra
	addi	ra, zero, 2
	rem	t0, t0, ra
	addi	ra, zero, 1
	sub	t0, ra, t0
	addi	ra, zero, 16
	mul	ra, t0, ra
	sll	ra, a0, ra
	or	ra, s6, ra
	sw	ra, 0(s5)
	j	.L12_10
.L12_10:
	addi	ra, s7, 4
	mv	s7, ra
	j	.L12_8
.L12_11:
	addi	s6, zero, 1
	mv	s5, s7
	j	.L12_12
.L12_12:
	addi	ra, zero, 4
	slt	ra, ra, s6
	xori	ra, ra, 1
	beqz	ra, .L12_32
	j	.L12_13
.L12_13:
	addi	s5, zero, 0
	j	.L12_14
.L12_14:
	slt	ra, s5, s6
	beqz	ra, .L12_17
	j	.L12_15
.L12_15:
	lui	ra, %hi(inputBuffer)
	lw	t0, %lo(inputBuffer)(ra)
	slli	ra, s5, 2
	add	t0, t0, ra
	addi	ra, zero, 48
	sw	ra, 0(t0)
	j	.L12_16
.L12_16:
	addi	s5, s5, 1
	j	.L12_14
.L12_17:
	j	.L12_18
.L12_18:
	j	.L12_19
.L12_19:
	lui	ra, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(ra)
	mv	a1, s6
	call	sha1
	mv	a1, s9
	call	array_equal
	beqz	a0, .L12_25
	j	.L12_20
.L12_20:
	addi	s5, zero, 0
	j	.L12_21
.L12_21:
	slt	ra, s5, s6
	beqz	ra, .L12_24
	j	.L12_22
.L12_22:
	lui	ra, %hi(inputBuffer)
	lw	t0, %lo(inputBuffer)(ra)
	slli	ra, s5, 2
	add	ra, t0, ra
	lw	a0, 0(ra)
	call	int2chr
	call	mx__print
	j	.L12_23
.L12_23:
	addi	s5, s5, 1
	j	.L12_21
.L12_24:
	la	a0, .str.1
	call	mx__println
	j	.L12_33
.L12_25:
	j	.L12_26
.L12_26:
	lui	ra, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(ra)
	mv	a1, s6
	call	nextText
	xori	ra, a0, 1
	beqz	ra, .L12_28
	j	.L12_27
.L12_27:
	j	.L12_30
.L12_28:
	j	.L12_29
.L12_29:
	j	.L12_18
.L12_30:
	j	.L12_31
.L12_31:
	addi	s6, s6, 1
	j	.L12_12
.L12_32:
	la	a0, .str.4
	call	mx__println
	j	.L12_33
.L12_33:
	lw	s5, 24(sp)
	lw	s6, 0(sp)
	lw	s7, 4(sp)
	lw	s8, 8(sp)
	lw	s9, 12(sp)
	lw	s10, 16(sp)
	lw	ra, 20(sp)
	addi	sp, sp, 28
	ret
	.size	crackSHA1, .-crackSHA1
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L13_0:
	addi	sp, sp, -16
	sw	ra, 8(sp)
	sw	s8, 12(sp)
	sw	s9, 0(sp)
	sw	s10, 4(sp)
	call	mx__init
	mv	s9, zero
	addi	ra, zero, 0
	j	.L13_1
.L13_1:
	j	.L13_2
.L13_2:
	call	mx__getInt
	mv	s8, a0
	addi	ra, s8, 0
	seqz	ra, ra
	beqz	ra, .L13_4
	j	.L13_3
.L13_3:
	mv	ra, s8
	j	.L13_12
.L13_4:
	j	.L13_5
.L13_5:
	addi	ra, s8, -1
	seqz	ra, ra
	beqz	ra, .L13_7
	j	.L13_6
.L13_6:
	call	mx__getString
	mv	s9, a0
	mv	a0, s9
	call	computeSHA1
	mv	ra, s9
	j	.L13_11
.L13_7:
	addi	ra, s8, -2
	seqz	ra, ra
	beqz	ra, .L13_9
	j	.L13_8
.L13_8:
	call	mx__getString
	mv	s9, a0
	mv	a0, s9
	call	crackSHA1
	mv	ra, s9
	j	.L13_10
.L13_9:
	mv	ra, s9
	j	.L13_10
.L13_10:
	j	.L13_11
.L13_11:
	mv	s9, ra
	mv	ra, s8
	j	.L13_1
.L13_12:
	j	.L13_13
.L13_13:
	mv	a0, zero
	lw	s8, 12(sp)
	lw	s9, 0(sp)
	lw	s10, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 16
	ret
	.size	main, .-main

	.section	.sdata,"aw",@progbits
	.str.0:
	.asciz	" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ "
	.global	asciiTable
	.p2align	2
	asciiTable:
	.word	0                       # 0
	.global	MAXCHUNK
	.p2align	2
	MAXCHUNK:
	.word	100                     # 100
	.global	MAXLENGTH
	.p2align	2
	MAXLENGTH:
	.word	0                       # 0
	.global	chunks
	.p2align	2
	chunks:
	.word	0                       # 0
	.global	inputBuffer
	.p2align	2
	inputBuffer:
	.word	0                       # 0
	.global	outputBuffer
	.p2align	2
	outputBuffer:
	.word	0                       # 0
	.str.1:
	.asciz	" "
	.str.2:
	.asciz	"nChunk > MAXCHUNK! "
	.str.3:
	.asciz	"Invalid input "
	.str.4:
	.asciz	"Not Found! "
