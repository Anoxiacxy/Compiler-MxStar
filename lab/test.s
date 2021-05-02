	.text

	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L0_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	a0, zero, 44
	call	malloc
	addi	ra, zero, 10
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(color)
	sw	ra, %lo(color)(t0)
	addi	a0, zero, 8
	call	malloc
	addi	ra, zero, 1
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(count)
	sw	ra, %lo(count)(t0)
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	mx__init, .-mx__init
	.globl	origin
	.p2align	2
	.type	origin,@function
origin:
.L1_0:
	addi	sp, sp, -16
	sw	ra, 8(sp)
	sw	s8, 12(sp)
	sw	s9, 0(sp)
	sw	s10, 4(sp)
	mv	s9, a0
	addi	ra, zero, 4
	mul	ra, s9, ra
	addi	a0, ra, 4
	call	malloc
	sw	s9, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(make)
	sw	ra, %lo(make)(t0)
	lui	ra, %hi(i)
	sw	zero, %lo(i)(ra)
	j	.L1_1
.L1_1:
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	slt	ra, ra, s9
	beqz	ra, .L1_6
	j	.L1_2
.L1_2:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	slli	ra, ra, 2
	add	s8, t0, ra
	addi	ra, zero, 4
	mul	ra, s9, ra
	addi	a0, ra, 4
	call	malloc
	sw	s9, 0(a0)
	addi	ra, a0, 4
	sw	ra, 0(s8)
	lui	ra, %hi(j)
	sw	zero, %lo(j)(ra)
	j	.L1_3
.L1_3:
	lui	ra, %hi(j)
	lw	ra, %lo(j)(ra)
	slt	ra, ra, s9
	beqz	ra, .L1_5
	j	.L1_4
.L1_4:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	lui	ra, %hi(j)
	lw	ra, %lo(j)(ra)
	slli	ra, ra, 2
	add	ra, t0, ra
	sw	zero, 0(ra)
	lui	ra, %hi(j)
	lw	ra, %lo(j)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(j)
	sw	t0, %lo(j)(ra)
	j	.L1_3
.L1_5:
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(i)
	sw	t0, %lo(i)(ra)
	j	.L1_1
.L1_6:
	lw	s8, 12(sp)
	lw	s9, 0(sp)
	lw	s10, 4(sp)
	lw	ra, 8(sp)
	addi	sp, sp, 16
	ret
	.size	origin, .-origin
	.globl	search
	.p2align	2
	.type	search,@function
search:
.L2_0:
	addi	sp, sp, -24
	sw	ra, 16(sp)
	sw	s6, 20(sp)
	sw	s7, 0(sp)
	sw	s8, 4(sp)
	sw	s9, 8(sp)
	sw	s10, 12(sp)
	mv	s7, a0
	mv	s8, a1
	mv	s9, a2
	slt	ra, zero, s8
	beqz	ra, .L2_2
	j	.L2_1
.L2_1:
	addi	ra, zero, 1
	j	.L2_3
.L2_2:
	slt	ra, s8, zero
	j	.L2_3
.L2_3:
	beqz	ra, .L2_5
	j	.L2_4
.L2_4:
	addi	ra, zero, 1
	j	.L2_6
.L2_5:
	addi	ra, s7, 0
	seqz	ra, ra
	j	.L2_6
.L2_6:
	beqz	ra, .L2_8
	j	.L2_7
.L2_7:
	addi	ra, zero, 1
	j	.L2_9
.L2_8:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	addi	ra, s7, -1
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	addi	ra, s7, -1
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	addi	ra, s7, -1
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	addi	ra, ra, -15
	seqz	ra, ra
	j	.L2_9
.L2_9:
	beqz	ra, .L2_68
	j	.L2_10
.L2_10:
	addi	ra, s7, -2
	seqz	ra, ra
	beqz	ra, .L2_11
	j	.L2_12
.L2_11:
	addi	ra, zero, 0
	j	.L2_13
.L2_12:
	addi	ra, s8, -2
	seqz	ra, ra
	j	.L2_13
.L2_13:
	beqz	ra, .L2_42
	j	.L2_14
.L2_14:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	t0, ra, 8
	addi	ra, zero, 45
	sub	ra, ra, s9
	sw	ra, 0(t0)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t0, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t0, t0, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	t0, t0, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	beqz	ra, .L2_15
	j	.L2_16
.L2_15:
	addi	ra, zero, 0
	j	.L2_17
.L2_16:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_17
.L2_17:
	beqz	ra, .L2_18
	j	.L2_19
.L2_18:
	addi	ra, zero, 0
	j	.L2_20
.L2_19:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_20
.L2_20:
	beqz	ra, .L2_21
	j	.L2_22
.L2_21:
	addi	ra, zero, 0
	j	.L2_23
.L2_22:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_23
.L2_23:
	beqz	ra, .L2_24
	j	.L2_25
.L2_24:
	addi	ra, zero, 0
	j	.L2_26
.L2_25:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_26
.L2_26:
	beqz	ra, .L2_27
	j	.L2_28
.L2_27:
	addi	ra, zero, 0
	j	.L2_29
.L2_28:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_29
.L2_29:
	beqz	ra, .L2_30
	j	.L2_31
.L2_30:
	addi	ra, zero, 0
	j	.L2_32
.L2_31:
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	addi	ra, ra, 0
	lw	t1, 0(ra)
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	addi	ra, ra, 4
	lw	ra, 0(ra)
	add	t1, t1, ra
	lui	ra, %hi(make)
	lw	ra, %lo(make)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 8
	lw	ra, 0(ra)
	add	ra, t1, ra
	sub	ra, ra, t0
	seqz	ra, ra
	j	.L2_32
.L2_32:
	beqz	ra, .L2_40
	j	.L2_33
.L2_33:
	lui	ra, %hi(count)
	lw	ra, %lo(count)(ra)
	addi	t0, ra, 0
	lui	ra, %hi(count)
	lw	ra, %lo(count)(ra)
	addi	ra, ra, 0
	lw	ra, 0(ra)
	addi	ra, ra, 1
	sw	ra, 0(t0)
	addi	s7, zero, 0
	j	.L2_34
.L2_34:
	addi	ra, zero, 2
	slt	ra, ra, s7
	xori	ra, ra, 1
	beqz	ra, .L2_39
	j	.L2_35
.L2_35:
	addi	s6, zero, 0
	j	.L2_36
.L2_36:
	addi	ra, zero, 2
	slt	ra, ra, s6
	xori	ra, ra, 1
	beqz	ra, .L2_38
	j	.L2_37
.L2_37:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s6, 2
	add	ra, t0, ra
	lw	a0, 0(ra)
	call	mx__toString
	call	mx__print
	la	a0, .str.0
	call	mx__print
	addi	s6, s6, 1
	j	.L2_36
.L2_38:
	la	a0, .str.1
	call	mx__print
	addi	s7, s7, 1
	j	.L2_34
.L2_39:
	la	a0, .str.1
	call	mx__print
	j	.L2_41
.L2_40:
	j	.L2_41
.L2_41:
	j	.L2_67
.L2_42:
	addi	ra, s8, -2
	seqz	ra, ra
	beqz	ra, .L2_56
	j	.L2_43
.L2_43:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lui	t0, %hi(make)
	lw	t1, %lo(make)(t0)
	slli	t0, s7, 2
	add	t0, t1, t0
	lw	t0, 0(t0)
	addi	t0, t0, 0
	lw	t1, 0(t0)
	addi	t0, zero, 15
	sub	t2, t0, t1
	lui	t0, %hi(make)
	lw	t1, %lo(make)(t0)
	slli	t0, s7, 2
	add	t0, t1, t0
	lw	t0, 0(t0)
	addi	t0, t0, 4
	lw	t0, 0(t0)
	sub	t0, t2, t0
	sw	t0, 0(ra)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	slt	ra, zero, ra
	beqz	ra, .L2_44
	j	.L2_45
.L2_44:
	addi	ra, zero, 0
	j	.L2_46
.L2_45:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	addi	ra, zero, 10
	slt	ra, t0, ra
	j	.L2_46
.L2_46:
	beqz	ra, .L2_47
	j	.L2_48
.L2_47:
	addi	ra, zero, 0
	j	.L2_49
.L2_48:
	lui	ra, %hi(color)
	lw	t1, %lo(color)(ra)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	slli	ra, ra, 2
	add	ra, t1, ra
	lw	ra, 0(ra)
	addi	ra, ra, 0
	seqz	ra, ra
	j	.L2_49
.L2_49:
	beqz	ra, .L2_54
	j	.L2_50
.L2_50:
	lui	ra, %hi(color)
	lw	t1, %lo(color)(ra)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	slli	ra, ra, 2
	add	t0, t1, ra
	addi	ra, zero, 1
	sw	ra, 0(t0)
	addi	ra, s8, -2
	seqz	ra, ra
	beqz	ra, .L2_52
	j	.L2_51
.L2_51:
	addi	a0, s7, 1
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	add	a2, s9, ra
	mv	a1, zero
	call	search
	j	.L2_53
.L2_52:
	addi	a1, s8, 1
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	add	a2, s9, ra
	mv	a0, s7
	call	search
	j	.L2_53
.L2_53:
	lui	ra, %hi(color)
	lw	t1, %lo(color)(ra)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	slli	ra, ra, 2
	add	ra, t1, ra
	sw	zero, 0(ra)
	j	.L2_55
.L2_54:
	j	.L2_55
.L2_55:
	j	.L2_66
.L2_56:
	addi	s6, zero, 1
	j	.L2_57
.L2_57:
	addi	ra, zero, 9
	slt	ra, ra, s6
	xori	ra, ra, 1
	beqz	ra, .L2_65
	j	.L2_58
.L2_58:
	lui	ra, %hi(color)
	lw	t0, %lo(color)(ra)
	slli	ra, s6, 2
	add	ra, t0, ra
	lw	ra, 0(ra)
	addi	ra, ra, 0
	seqz	ra, ra
	beqz	ra, .L2_63
	j	.L2_59
.L2_59:
	lui	ra, %hi(color)
	lw	t0, %lo(color)(ra)
	slli	ra, s6, 2
	add	t0, t0, ra
	addi	ra, zero, 1
	sw	ra, 0(t0)
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	sw	s6, 0(ra)
	addi	ra, s8, -2
	seqz	ra, ra
	beqz	ra, .L2_61
	j	.L2_60
.L2_60:
	addi	a0, s7, 1
	add	a2, s9, s6
	mv	a1, zero
	call	search
	j	.L2_62
.L2_61:
	addi	a1, s8, 1
	add	a2, s9, s6
	mv	a0, s7
	call	search
	j	.L2_62
.L2_62:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	slli	ra, s7, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	slli	ra, s8, 2
	add	ra, t0, ra
	sw	zero, 0(ra)
	lui	ra, %hi(color)
	lw	t0, %lo(color)(ra)
	slli	ra, s6, 2
	add	ra, t0, ra
	sw	zero, 0(ra)
	j	.L2_64
.L2_63:
	j	.L2_64
.L2_64:
	addi	ra, s6, 1
	mv	s6, ra
	j	.L2_57
.L2_65:
	j	.L2_66
.L2_66:
	j	.L2_67
.L2_67:
	j	.L2_69
.L2_68:
	j	.L2_69
.L2_69:
	lw	s6, 20(sp)
	lw	s7, 0(sp)
	lw	s8, 4(sp)
	lw	s9, 8(sp)
	lw	s10, 12(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 24
	ret
	.size	search, .-search
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L3_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	sw	s9, 8(sp)
	sw	s10, 0(sp)
	addi	a0, zero, 44
	call	malloc
	addi	ra, zero, 10
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(color)
	sw	ra, %lo(color)(t0)
	addi	a0, zero, 8
	call	malloc
	addi	ra, zero, 1
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(count)
	sw	ra, %lo(count)(t0)
	lui	ra, %hi(count)
	lw	ra, %lo(count)(ra)
	addi	ra, ra, 0
	sw	zero, 0(ra)
	addi	a0, zero, 16
	call	malloc
	addi	ra, zero, 3
	sw	ra, 0(a0)
	addi	ra, a0, 4
	lui	t0, %hi(make)
	sw	ra, %lo(make)(t0)
	lui	ra, %hi(i)
	sw	zero, %lo(i)(ra)
	j	.L3_1
.L3_1:
	lui	ra, %hi(i)
	lw	t0, %lo(i)(ra)
	addi	ra, zero, 3
	slt	ra, t0, ra
	beqz	ra, .L3_6
	j	.L3_2
.L3_2:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	slli	ra, ra, 2
	add	s9, t0, ra
	addi	a0, zero, 16
	call	malloc
	addi	ra, zero, 3
	sw	ra, 0(a0)
	addi	ra, a0, 4
	sw	ra, 0(s9)
	lui	ra, %hi(j)
	sw	zero, %lo(j)(ra)
	j	.L3_3
.L3_3:
	lui	ra, %hi(j)
	lw	t0, %lo(j)(ra)
	addi	ra, zero, 3
	slt	ra, t0, ra
	beqz	ra, .L3_5
	j	.L3_4
.L3_4:
	lui	ra, %hi(make)
	lw	t0, %lo(make)(ra)
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	slli	ra, ra, 2
	add	ra, t0, ra
	lw	t0, 0(ra)
	lui	ra, %hi(j)
	lw	ra, %lo(j)(ra)
	slli	ra, ra, 2
	add	ra, t0, ra
	sw	zero, 0(ra)
	lui	ra, %hi(j)
	lw	ra, %lo(j)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(j)
	sw	t0, %lo(j)(ra)
	j	.L3_3
.L3_5:
	lui	ra, %hi(i)
	lw	ra, %lo(i)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(i)
	sw	t0, %lo(i)(ra)
	j	.L3_1
.L3_6:
	mv	a0, zero
	mv	a1, zero
	mv	a2, zero
	call	search
	lui	ra, %hi(count)
	lw	ra, %lo(count)(ra)
	addi	ra, ra, 0
	lw	a0, 0(ra)
	call	mx__toString
	call	mx__println
	mv	a0, zero
	lw	s9, 8(sp)
	lw	s10, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	main, .-main

	.section	.sdata,"aw",@progbits
	.global	make
	.p2align	2
	make:
	.word	0                       # 0
	.global	color
	.p2align	2
	color:
	.word	0                       # 0
	.global	count
	.p2align	2
	count:
	.word	0                       # 0
	.global	i
	.p2align	2
	i:
	.word	0                       # 0
	.global	j
	.p2align	2
	j:
	.word	0                       # 0
	.str.0:
	.asciz	"  "
	.str.1:
	.asciz	"\n "
