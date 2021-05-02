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
	beqz	ra, .L1_20
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
	j	.L1_19
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
	j	.L1_18
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
	j	.L1_21
.L1_18:
	j	.L1_19
.L1_19:
	addi	ra, s9, 1
	mv	s8, t0
	mv	s9, ra
	j	.L1_1
.L1_20:
	mv	a0, s8
	j	.L1_21
.L1_21:
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
	j	.L2_6
.L2_5:
	la	a0, .str.1
	j	.L2_6
.L2_6:
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
	beqz	ra, .L3_6
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
	addi	ra, s9, -4
	mv	s8, a0
	mv	s9, ra
	j	.L3_1
.L3_6:
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
	j	.L4_5
.L4_2:
	addi	t0, a1, -31
	seqz	t0, t0
	beqz	t0, .L4_4
	j	.L4_3
.L4_3:
	andi	t0, a0, 1
	slli	t2, t0, 31
	srai	t1, a0, 1
	li	t0, 2147483647
	and	t0, t1, t0
	or	a0, t2, t0
	j	.L4_5
.L4_4:
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
	j	.L4_5
.L4_5:
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
	ret
	.size	add, .-add
	.globl	lohi
	.p2align	2
	.type	lohi,@function
lohi:
.L6_0:
	slli	t0, a1, 16
	or	a0, a0, t0
	ret
	.size	lohi, .-lohi
	.globl	sha1
	.p2align	2
	.type	sha1,@function
sha1:
.L7_0:
	addi	sp, sp, -80
	sw	ra, 76(sp)
	sw	s0, 28(sp)
	sw	s1, 32(sp)
	sw	s2, 36(sp)
	sw	s3, 40(sp)
	sw	s4, 44(sp)
	sw	s5, 48(sp)
	sw	s6, 52(sp)
	sw	s7, 56(sp)
	sw	s8, 60(sp)
	sw	s9, 64(sp)
	sw	s10, 68(sp)
	sw	s11, 72(sp)
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
	mv	a0, zero
	j	.L7_30
.L7_2:
	addi	ra, zero, 0
	j	.L7_3
.L7_3:
	slt	t0, ra, s4
	beqz	t0, .L7_8
	j	.L7_4
.L7_4:
	addi	t0, zero, 0
	j	.L7_5
.L7_5:
	addi	t1, zero, 80
	slt	t1, t0, t1
	beqz	t1, .L7_7
	j	.L7_6
.L7_6:
	lui	t1, %hi(chunks)
	lw	t2, %lo(chunks)(t1)
	slli	t1, ra, 2
	add	t1, t2, t1
	lw	t2, 0(t1)
	slli	t1, t0, 2
	add	t1, t2, t1
	sw	zero, 0(t1)
	addi	t0, t0, 1
	j	.L7_5
.L7_7:
	addi	ra, ra, 1
	j	.L7_3
.L7_8:
	addi	ra, zero, 0
	j	.L7_9
.L7_9:
	slt	t0, ra, a1
	beqz	t0, .L7_11
	j	.L7_10
.L7_10:
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
	addi	ra, ra, 1
	j	.L7_9
.L7_11:
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
	mv	s0, a0
	li	a0, 56574
	li	a1, 39098
	call	lohi
	mv	s1, a0
	li	a0, 57840
	li	a1, 50130
	call	lohi
	addi	s9, zero, 0
	mv	s5, a0
	li	ra, 271733878
	mv	s6, ra
	mv	s7, s1
	mv	s8, s0
	li	ra, 1732584193
	mv	s10, ra
	j	.L7_12
.L7_12:
	slt	ra, s9, s4
	beqz	ra, .L7_29
	j	.L7_13
.L7_13:
	addi	s1, zero, 16
	j	.L7_14
.L7_14:
	addi	ra, zero, 80
	slt	ra, s1, ra
	beqz	ra, .L7_16
	j	.L7_15
.L7_15:
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s1, 2
	add	s0, t0, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s1, -3
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	t1, 0(ra)
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s1, -8
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	t1, t1, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s1, -14
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	t1, t1, ra
	lui	ra, %hi(chunks)
	lw	t0, %lo(chunks)(ra)
	slli	ra, s9, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, s1, -16
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	xor	a0, t1, ra
	addi	a1, zero, 1
	call	rotate_left
	sw	a0, 0(s0)
	addi	s1, s1, 1
	j	.L7_14
.L7_16:
	addi	s0, zero, 0
	mv	s11, s10
	mv	s1, s8
	mv	s2, s7
	mv	s3, s6
	mv	ra, s5
	sw	ra, 0(sp)
	j	.L7_17
.L7_17:
	addi	ra, zero, 80
	slt	ra, s0, ra
	beqz	ra, .L7_28
	j	.L7_18
.L7_18:
	addi	ra, zero, 20
	slt	ra, s0, ra
	beqz	ra, .L7_20
	j	.L7_19
.L7_19:
	and	t0, s1, s2
	xori	ra, s1, -1
	and	ra, ra, s3
	or	t0, t0, ra
	li	ra, 1518500249
	sw	ra, 4(sp)
	sw	t0, 8(sp)
	j	.L7_27
.L7_20:
	addi	ra, zero, 40
	slt	ra, s0, ra
	beqz	ra, .L7_22
	j	.L7_21
.L7_21:
	xor	ra, s1, s2
	xor	ra, ra, s3
	li	a0, 1859775393
	j	.L7_26
.L7_22:
	addi	ra, zero, 60
	slt	ra, s0, ra
	beqz	ra, .L7_24
	j	.L7_23
.L7_23:
	and	t0, s1, s2
	and	ra, s1, s3
	or	t0, t0, ra
	and	ra, s2, s3
	or	ra, t0, ra
	sw	ra, 16(sp)
	li	a0, 48348
	li	a1, 36635
	call	lohi
	lw	ra, 16(sp)
	j	.L7_25
.L7_24:
	xor	ra, s1, s2
	xor	ra, ra, s3
	sw	ra, 20(sp)
	li	a0, 49622
	li	a1, 51810
	call	lohi
	lw	ra, 20(sp)
	j	.L7_25
.L7_25:
	j	.L7_26
.L7_26:
	sw	a0, 4(sp)
	sw	ra, 8(sp)
	j	.L7_27
.L7_27:
	mv	a0, s11
	addi	a1, zero, 5
	call	rotate_left
	lw	a1, 0(sp)
	call	add
	sw	a0, 24(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	add
	mv	a1, a0
	lw	a0, 24(sp)
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
	sw	a0, 12(sp)
	mv	a0, s1
	addi	a1, zero, 30
	call	rotate_left
	addi	ra, s0, 1
	mv	s0, ra
	mv	s1, s11
	lw	ra, 12(sp)
	mv	s11, ra
	mv	ra, s3
	sw	ra, 0(sp)
	mv	s3, s2
	mv	s2, a0
	j	.L7_17
.L7_28:
	mv	a0, s10
	mv	a1, s11
	call	add
	mv	s0, a0
	mv	a0, s8
	mv	a1, s1
	call	add
	mv	s1, a0
	mv	a0, s7
	mv	a1, s2
	call	add
	mv	s2, a0
	mv	a0, s6
	mv	a1, s3
	call	add
	mv	s3, a0
	mv	a0, s5
	lw	a1, 0(sp)
	call	add
	addi	ra, s9, 1
	mv	s9, ra
	mv	s5, a0
	mv	s6, s3
	mv	s7, s2
	mv	s8, s1
	mv	s10, s0
	j	.L7_12
.L7_29:
	lui	ra, %hi(outputBuffer)
	lw	ra, %lo(outputBuffer)(ra)
	addi	ra, ra, 0
	sw	s10, 0(ra)
	lui	ra, %hi(outputBuffer)
	lw	ra, %lo(outputBuffer)(ra)
	addi	ra, ra, 4
	sw	s8, 0(ra)
	lui	ra, %hi(outputBuffer)
	lw	ra, %lo(outputBuffer)(ra)
	addi	ra, ra, 8
	sw	s7, 0(ra)
	lui	ra, %hi(outputBuffer)
	lw	ra, %lo(outputBuffer)(ra)
	addi	ra, ra, 12
	sw	s6, 0(ra)
	lui	ra, %hi(outputBuffer)
	lw	ra, %lo(outputBuffer)(ra)
	addi	ra, ra, 16
	sw	s5, 0(ra)
	lui	ra, %hi(outputBuffer)
	lw	a0, %lo(outputBuffer)(ra)
	j	.L7_30
.L7_30:
	lw	s0, 28(sp)
	lw	s1, 32(sp)
	lw	s2, 36(sp)
	lw	s3, 40(sp)
	lw	s4, 44(sp)
	lw	s5, 48(sp)
	lw	s6, 52(sp)
	lw	s7, 56(sp)
	lw	s8, 60(sp)
	lw	s9, 64(sp)
	lw	s10, 68(sp)
	lw	s11, 72(sp)
	lw	ra, 76(sp)
	addi	sp, sp, 80
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
	beqz	ra, .L8_3
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
	addi	ra, s9, 1
	mv	s9, ra
	j	.L8_1
.L8_3:
	lui	ra, %hi(inputBuffer)
	lw	s7, %lo(inputBuffer)(ra)
	mv	a0, s8
	call	mx__string_length
	mv	a1, a0
	mv	a0, s7
	call	sha1
	mv	s7, a0
	addi	s8, zero, 0
	j	.L8_4
.L8_4:
	addi	ra, s7, -4
	lw	ra, 0(ra)
	slt	ra, s8, ra
	beqz	ra, .L8_6
	j	.L8_5
.L8_5:
	slli	ra, s8, 2
	add	ra, s7, ra
	lw	a0, 0(ra)
	call	toStringHex
	call	mx__print
	addi	s8, s8, 1
	j	.L8_4
.L8_6:
	la	a0, .str.1
	call	mx__println
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
	j	.L9_7
.L9_2:
	addi	t0, a0, -90
	seqz	t0, t0
	beqz	t0, .L9_4
	j	.L9_3
.L9_3:
	addi	a0, zero, 97
	j	.L9_7
.L9_4:
	addi	t0, a0, -57
	seqz	t0, t0
	beqz	t0, .L9_6
	j	.L9_5
.L9_5:
	addi	a0, zero, 65
	j	.L9_7
.L9_6:
	addi	a0, a0, 1
	j	.L9_7
.L9_7:
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
	beqz	ra, .L10_5
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
	addi	ra, s9, -1
	mv	s9, ra
	j	.L10_1
.L10_4:
	addi	a0, zero, 1
	j	.L10_6
.L10_5:
	addi	a0, zero, 0
	j	.L10_6
.L10_6:
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
	addi	a0, zero, 0
	j	.L11_8
.L11_2:
	addi	t0, zero, 0
	j	.L11_3
.L11_3:
	addi	t1, a0, -4
	lw	t1, 0(t1)
	slt	t1, t0, t1
	beqz	t1, .L11_7
	j	.L11_4
.L11_4:
	slli	t1, t0, 2
	add	t1, a0, t1
	lw	t2, 0(t1)
	slli	t1, t0, 2
	add	t1, a1, t1
	lw	t1, 0(t1)
	sub	t1, t2, t1
	snez	t1, t1
	beqz	t1, .L11_6
	j	.L11_5
.L11_5:
	addi	a0, zero, 0
	j	.L11_8
.L11_6:
	addi	t0, t0, 1
	j	.L11_3
.L11_7:
	addi	a0, zero, 1
	j	.L11_8
.L11_8:
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
	j	.L12_23
.L12_2:
	addi	ra, zero, 0
	j	.L12_3
.L12_3:
	addi	t0, zero, 5
	slt	t0, ra, t0
	beqz	t0, .L12_5
	j	.L12_4
.L12_4:
	slli	t0, ra, 2
	add	t0, s9, t0
	sw	zero, 0(t0)
	addi	ra, ra, 1
	j	.L12_3
.L12_5:
	addi	s7, zero, 0
	j	.L12_6
.L12_6:
	addi	ra, zero, 40
	slt	ra, s7, ra
	beqz	ra, .L12_8
	j	.L12_7
.L12_7:
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
	addi	ra, s7, 4
	mv	s7, ra
	j	.L12_6
.L12_8:
	addi	s5, zero, 1
	j	.L12_9
.L12_9:
	addi	ra, zero, 4
	slt	ra, ra, s5
	xori	ra, ra, 1
	beqz	ra, .L12_22
	j	.L12_10
.L12_10:
	addi	ra, zero, 0
	j	.L12_11
.L12_11:
	slt	t0, ra, s5
	beqz	t0, .L12_13
	j	.L12_12
.L12_12:
	lui	t0, %hi(inputBuffer)
	lw	t1, %lo(inputBuffer)(t0)
	slli	t0, ra, 2
	add	t1, t1, t0
	addi	t0, zero, 48
	sw	t0, 0(t1)
	addi	ra, ra, 1
	j	.L12_11
.L12_13:
	j	.L12_14
.L12_14:
	lui	ra, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(ra)
	mv	a1, s5
	call	sha1
	mv	a1, s9
	call	array_equal
	beqz	a0, .L12_19
	j	.L12_15
.L12_15:
	addi	s6, zero, 0
	j	.L12_16
.L12_16:
	slt	ra, s6, s5
	beqz	ra, .L12_18
	j	.L12_17
.L12_17:
	lui	ra, %hi(inputBuffer)
	lw	t0, %lo(inputBuffer)(ra)
	slli	ra, s6, 2
	add	ra, t0, ra
	lw	a0, 0(ra)
	call	int2chr
	call	mx__print
	addi	s6, s6, 1
	j	.L12_16
.L12_18:
	la	a0, .str.1
	call	mx__println
	j	.L12_23
.L12_19:
	lui	ra, %hi(inputBuffer)
	lw	a0, %lo(inputBuffer)(ra)
	mv	a1, s5
	call	nextText
	xori	ra, a0, 1
	beqz	ra, .L12_21
	j	.L12_20
.L12_20:
	addi	s5, s5, 1
	j	.L12_9
.L12_21:
	j	.L12_14
.L12_22:
	la	a0, .str.4
	call	mx__println
	j	.L12_23
.L12_23:
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
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	mx__init
	j	.L13_1
.L13_1:
	call	mx__getInt
	addi	ra, a0, 0
	seqz	ra, ra
	beqz	ra, .L13_2
	j	.L13_9
.L13_2:
	addi	ra, a0, -1
	seqz	ra, ra
	beqz	ra, .L13_4
	j	.L13_3
.L13_3:
	call	mx__getString
	call	computeSHA1
	j	.L13_8
.L13_4:
	addi	ra, a0, -2
	seqz	ra, ra
	beqz	ra, .L13_6
	j	.L13_5
.L13_5:
	call	mx__getString
	call	crackSHA1
	j	.L13_7
.L13_6:
	j	.L13_7
.L13_7:
	j	.L13_8
.L13_8:
	j	.L13_1
.L13_9:
	mv	a0, zero
	lw	ra, 0(sp)
	addi	sp, sp, 4
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
