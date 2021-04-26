	.text

	.globl	search
	.p2align	2
	.type	search,@function
search:
.L0_0:
	addi	sp, sp, -36
	sw	ra, 28(sp)
	sw	s11, 24(sp)
	sw	s10, 8(sp)
	sw	s0, 12(sp)
	sw	s1, 4(sp)
	sw	s5, 32(sp)
	sw	s6, 0(sp)
	sw	s7, 16(sp)
	sw	s8, 20(sp)
	mv	s1, a0
	mv	s7, a1
	mv	s11, a2
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	sw	s1, 0(s5)
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	sw	s7, 0(s1)
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	sw	s11, 0(s7)
	lw	t4, 0(s1)
	slt	t4, zero, t4
	beqz	t4, .L0_2
	j	.L0_1
.L0_1:
	addi	t4, zero, 1
	j	.L0_3
.L0_2:
	lw	t4, 0(s1)
	slt	t4, t4, zero
	j	.L0_3
.L0_3:
	beqz	t4, .L0_5
	j	.L0_4
.L0_4:
	addi	t4, zero, 1
	j	.L0_6
.L0_5:
	lw	t4, 0(s5)
	addi	t4, t4, 0
	seqz	t4, t4
	j	.L0_6
.L0_6:
	beqz	t4, .L0_8
	j	.L0_7
.L0_7:
	addi	t4, zero, 1
	j	.L0_9
.L0_8:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t5, 0(s5)
	addi	t5, t5, -1
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t6, %lo(make)(t4)
	lw	t4, 0(s5)
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t6, t5, t4
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lw	t4, 0(s5)
	addi	t4, t4, -1
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t4, t6, t4
	addi	t4, t4, -15
	seqz	t4, t4
	j	.L0_9
.L0_9:
	beqz	t4, .L0_71
	j	.L0_10
.L0_10:
	lw	t4, 0(s5)
	addi	t4, t4, -2
	seqz	t4, t4
	beqz	t4, .L0_11
	j	.L0_12
.L0_11:
	addi	t4, zero, 0
	j	.L0_13
.L0_12:
	lw	t4, 0(s1)
	addi	t4, t4, -2
	seqz	t4, t4
	j	.L0_13
.L0_13:
	beqz	t4, .L0_44
	j	.L0_14
.L0_14:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t6, t4, 8
	lw	t4, 0(t6)
	lw	t4, 0(s7)
	addi	t5, zero, 45
	sub	t4, t5, t4
	sw	t4, 0(t6)
	lw	t4, 0(s0)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t4, t5, t4
	sw	t4, 0(s0)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s0)
	sub	t4, t5, t4
	seqz	t4, t4
	beqz	t4, .L0_15
	j	.L0_16
.L0_15:
	addi	t4, zero, 0
	j	.L0_17
.L0_16:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s0)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_17
.L0_17:
	beqz	t4, .L0_18
	j	.L0_19
.L0_18:
	addi	t4, zero, 0
	j	.L0_20
.L0_19:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	add	t4, t5, t4
	lui	t5, %hi(make)
	lw	t5, %lo(make)(t5)
	addi	t5, t5, 8
	lw	t5, 0(t5)
	addi	t5, t5, 0
	lw	t5, 0(t5)
	add	t5, t4, t5
	lw	t4, 0(s0)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_20
.L0_20:
	beqz	t4, .L0_21
	j	.L0_22
.L0_21:
	addi	t4, zero, 0
	j	.L0_23
.L0_22:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s0)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_23
.L0_23:
	beqz	t4, .L0_24
	j	.L0_25
.L0_24:
	addi	t4, zero, 0
	j	.L0_26
.L0_25:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s0)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_26
.L0_26:
	beqz	t4, .L0_27
	j	.L0_28
.L0_27:
	addi	t4, zero, 0
	j	.L0_29
.L0_28:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s0)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_29
.L0_29:
	beqz	t4, .L0_30
	j	.L0_31
.L0_30:
	addi	t4, zero, 0
	j	.L0_32
.L0_31:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	addi	t4, t4, 4
	lw	t4, 0(t4)
	add	t5, t5, t4
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 8
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s0)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_32
.L0_32:
	beqz	t4, .L0_42
	j	.L0_33
.L0_33:
	lui	t4, %hi(count)
	lw	t4, %lo(count)(t4)
	addi	t5, t4, 0
	lw	t4, 0(t5)
	lui	t4, %hi(count)
	lw	t4, %lo(count)(t4)
	addi	t4, t4, 0
	lw	t4, 0(t4)
	addi	t4, t4, 1
	sw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	zero, 0(s6)
	j	.L0_34
.L0_34:
	lw	t4, 0(s6)
	addi	t5, zero, 2
	slt	t4, t5, t4
	xori	t4, t4, 1
	beqz	t4, .L0_41
	j	.L0_35
.L0_35:
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	j	.L0_36
.L0_36:
	lw	t4, 0(s10)
	addi	t5, zero, 2
	slt	t4, t5, t4
	xori	t4, t4, 1
	beqz	t4, .L0_39
	j	.L0_37
.L0_37:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__print
	la	a0, .str.0
	call	mx__print
	j	.L0_38
.L0_38:
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	j	.L0_36
.L0_39:
	la	a0, .str.1
	call	mx__print
	j	.L0_40
.L0_40:
	lw	t4, 0(s6)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	j	.L0_34
.L0_41:
	la	a0, .str.1
	call	mx__print
	j	.L0_43
.L0_42:
	j	.L0_43
.L0_43:
	j	.L0_70
.L0_44:
	lw	t4, 0(s1)
	addi	t4, t4, -2
	seqz	t4, t4
	beqz	t4, .L0_58
	j	.L0_45
.L0_45:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lui	t5, %hi(make)
	lw	t6, %lo(make)(t5)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t5, 0(t5)
	addi	t5, t5, 0
	lw	t5, 0(t5)
	addi	t6, zero, 15
	sub	ra, t6, t5
	lui	t5, %hi(make)
	lw	t6, %lo(make)(t5)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t5, 0(t5)
	addi	t5, t5, 4
	lw	t5, 0(t5)
	sub	t5, ra, t5
	sw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s1)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	slt	t4, zero, t4
	beqz	t4, .L0_46
	j	.L0_47
.L0_46:
	addi	t4, zero, 0
	j	.L0_48
.L0_47:
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	addi	t4, zero, 10
	slt	t4, t5, t4
	j	.L0_48
.L0_48:
	beqz	t4, .L0_49
	j	.L0_50
.L0_49:
	addi	t4, zero, 0
	j	.L0_51
.L0_50:
	lui	t4, %hi(color)
	lw	t6, %lo(color)(t4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	addi	t4, t4, 0
	seqz	t4, t4
	j	.L0_51
.L0_51:
	beqz	t4, .L0_56
	j	.L0_52
.L0_52:
	lui	t4, %hi(color)
	lw	t5, %lo(color)(t4)
	lui	t4, %hi(make)
	lw	t6, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	lw	t6, 0(s1)
	slli	t6, t6, 2
	add	t4, t4, t6
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	addi	t5, zero, 1
	sw	t5, 0(t4)
	lw	t4, 0(s1)
	addi	t4, t4, -2
	seqz	t4, t4
	beqz	t4, .L0_54
	j	.L0_53
.L0_53:
	lw	t4, 0(s5)
	addi	a0, t4, 1
	lw	t6, 0(s7)
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	add	a2, t6, t4
	mv	a1, zero
	call	search
	j	.L0_55
.L0_54:
	lw	a0, 0(s5)
	lw	t4, 0(s1)
	addi	a1, t4, 1
	lw	t5, 0(s7)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t6, 0(s5)
	slli	t6, t6, 2
	add	t4, t4, t6
	lw	t4, 0(t4)
	lw	t6, 0(s1)
	slli	t6, t6, 2
	add	t4, t4, t6
	lw	t4, 0(t4)
	add	a2, t5, t4
	call	search
	j	.L0_55
.L0_55:
	lui	t4, %hi(color)
	lw	t5, %lo(color)(t4)
	lui	t4, %hi(make)
	lw	t6, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	lw	t6, 0(s1)
	slli	t6, t6, 2
	add	t4, t4, t6
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L0_57
.L0_56:
	j	.L0_57
.L0_57:
	j	.L0_69
.L0_58:
	lw	t4, 0(s6)
	addi	t4, zero, 1
	sw	t4, 0(s6)
	j	.L0_59
.L0_59:
	lw	t5, 0(s6)
	addi	t4, zero, 9
	slt	t4, t4, t5
	xori	t4, t4, 1
	beqz	t4, .L0_68
	j	.L0_60
.L0_60:
	lui	t4, %hi(color)
	lw	t5, %lo(color)(t4)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L0_65
	j	.L0_61
.L0_61:
	lui	t4, %hi(color)
	lw	t5, %lo(color)(t4)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	addi	t5, zero, 1
	sw	t5, 0(t4)
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lw	t4, 0(s5)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s1)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t4, 0(s1)
	addi	t4, t4, -2
	seqz	t4, t4
	beqz	t4, .L0_63
	j	.L0_62
.L0_62:
	lw	t4, 0(s5)
	addi	a0, t4, 1
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	add	a2, t5, t4
	mv	a1, zero
	call	search
	j	.L0_64
.L0_63:
	lw	a0, 0(s5)
	lw	t4, 0(s1)
	addi	a1, t4, 1
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	add	a2, t5, t4
	call	search
	j	.L0_64
.L0_64:
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	t5, 0(s5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s1)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	lui	t4, %hi(color)
	lw	t5, %lo(color)(t4)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L0_66
.L0_65:
	j	.L0_66
.L0_66:
	j	.L0_67
.L0_67:
	lw	t4, 0(s6)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	j	.L0_59
.L0_68:
	j	.L0_69
.L0_69:
	j	.L0_70
.L0_70:
	j	.L0_72
.L0_71:
	j	.L0_72
.L0_72:
	j	.L0_73
.L0_73:
	lw	s11, 24(sp)
	lw	s10, 8(sp)
	lw	s0, 12(sp)
	lw	s1, 4(sp)
	lw	s5, 32(sp)
	lw	s6, 0(sp)
	lw	s7, 16(sp)
	lw	s8, 20(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 36
	ret
	.size	search, .-search
	.globl	origin
	.p2align	2
	.type	origin,@function
origin:
.L1_0:
	addi	sp, sp, -20
	sw	ra, 0(sp)
	sw	s2, 8(sp)
	sw	s4, 12(sp)
	sw	s5, 16(sp)
	sw	s7, 4(sp)
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	sw	s2, 0(s4)
	lui	t4, %hi(make)
	lw	t4, %lo(make)(t4)
	lw	s2, 0(s4)
	addi	t4, zero, 4
	mul	t4, s2, t4
	addi	a0, t4, 4
	call	malloc
	sw	s2, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(make)
	sw	t4, %lo(make)(t5)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	sw	zero, %lo(i)(t4)
	j	.L1_1
.L1_1:
	lui	t4, %hi(i)
	lw	t5, %lo(i)(t4)
	lw	t4, 0(s4)
	slt	t4, t5, t4
	beqz	t4, .L1_8
	j	.L1_2
.L1_2:
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slli	t4, t4, 2
	add	s5, t5, t4
	lw	t4, 0(s5)
	lw	s2, 0(s4)
	addi	t4, zero, 4
	mul	t4, s2, t4
	addi	a0, t4, 4
	call	malloc
	sw	s2, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s5)
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	lui	t4, %hi(j)
	sw	zero, %lo(j)(t4)
	j	.L1_3
.L1_3:
	lui	t4, %hi(j)
	lw	t5, %lo(j)(t4)
	lw	t4, 0(s4)
	slt	t4, t5, t4
	beqz	t4, .L1_6
	j	.L1_4
.L1_4:
	lui	t4, %hi(make)
	lw	t5, %lo(make)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	j	.L1_5
.L1_5:
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(j)
	sw	t5, %lo(j)(t4)
	j	.L1_3
.L1_6:
	j	.L1_7
.L1_7:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	addi	t4, t4, 1
	lui	t5, %hi(i)
	sw	t4, %lo(i)(t5)
	j	.L1_1
.L1_8:
	j	.L1_9
.L1_9:
	lw	s2, 8(sp)
	lw	s4, 12(sp)
	lw	s5, 16(sp)
	lw	s7, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 20
	ret
	.size	origin, .-origin
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L2_0:
	addi	sp, sp, -8
	sw	ra, 0(sp)
	sw	s0, 4(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	lui	t4, %hi(count)
	lw	t4, %lo(count)(t4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	addi	a0, zero, 3
	call	origin
	mv	a0, zero
	mv	a1, zero
	mv	a2, zero
	call	search
	lui	t4, %hi(count)
	lw	t4, %lo(count)(t4)
	addi	t4, t4, 0
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__println
	sw	zero, 0(s0)
	j	.L2_2
.L2_1:
	j	.L2_2
.L2_2:
	lw	a0, 0(s0)
	lw	s0, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 8
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L3_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	t4, zero, 4
	addi	t5, zero, 10
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 10
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(color)
	sw	t4, %lo(color)(t5)
	addi	t4, zero, 4
	addi	t5, zero, 1
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 1
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(count)
	sw	t4, %lo(count)(t5)
	j	.L3_1
.L3_1:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
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
	.global	make
	.p2align	2
	make:
	.word	0                       # 0
	.str.1:
	.asciz	"\n "
