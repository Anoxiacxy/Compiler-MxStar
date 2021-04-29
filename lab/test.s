	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -92
	sw	ra, 80(sp)
	sw	s11, 52(sp)
	sw	s10, 76(sp)
	sw	s0, 24(sp)
	sw	s1, 72(sp)
	sw	s2, 16(sp)
	sw	s3, 44(sp)
	sw	s4, 84(sp)
	sw	s5, 8(sp)
	sw	s6, 40(sp)
	sw	s7, 4(sp)
	sw	s8, 56(sp)
	sw	s9, 64(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	sw	a0, 88(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	addi	a0, zero, 4
	call	malloc
	mv	s8, a0
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 28(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s9, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 68(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 0(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 36(sp)
	lw	t4, 36(sp)
	sw	zero, 0(t4)
	sw	zero, 0(s5)
	sw	zero, 0(s2)
	lw	t4, 0(sp)
	sw	zero, 0(t4)
	lw	t4, 68(sp)
	sw	zero, 0(t4)
	sw	zero, 0(s9)
	lw	t4, 28(sp)
	sw	zero, 0(t4)
	sw	zero, 0(s10)
	sw	zero, 0(s0)
	sw	zero, 0(s8)
	sw	zero, 0(s6)
	sw	zero, 0(s3)
	sw	zero, 0(s1)
	sw	zero, 0(s4)
	sw	zero, 0(s7)
	sw	zero, 0(s11)
	lw	t4, 88(sp)
	sw	zero, 0(t4)
	lw	t4, 0(s5)
	call	mx__getInt
	sw	a0, 0(s5)
	lw	t4, 0(s2)
	sw	zero, 0(s2)
	lw	t4, 0(s10)
	sw	zero, 0(s10)
	lw	t4, 0(sp)
	lw	t4, 0(t4)
	lw	t4, 0(sp)
	sw	zero, 0(t4)
	lw	t4, 68(sp)
	lw	t4, 0(t4)
	lw	t4, 68(sp)
	sw	zero, 0(t4)
	lw	t4, 0(s9)
	lw	t4, 0(s5)
	addi	t4, t4, -1
	sw	t4, 0(s9)
	lw	t4, 28(sp)
	lw	t4, 0(t4)
	lw	t4, 0(s5)
	addi	t5, t4, -1
	lw	t4, 28(sp)
	sw	t5, 0(t4)
	lw	t4, 0(s6)
	sw	zero, 0(s6)
	lw	t4, 0(s3)
	sw	zero, 0(s3)
	lw	t4, 0(s8)
	sw	zero, 0(s8)
	lw	t4, 0(s0)
	sw	zero, 0(s0)
	lw	t4, 0(s1)
	lw	t4, 0(s5)
	lw	t5, 0(s5)
	mul	t4, t4, t5
	sw	t4, 12(sp)
	addi	t4, zero, 4
	lw	t5, 12(sp)
	mul	t4, t5, t4
	addi	a0, t4, 4
	call	malloc
	lw	t4, 12(sp)
	sw	t4, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s1)
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_1
.L0_1:
	lw	t4, 0(s11)
	lw	t6, 0(s5)
	lw	t5, 0(s5)
	mul	t5, t6, t5
	slt	t4, t4, t5
	beqz	t4, .L0_4
	j	.L0_2
.L0_2:
	lw	t5, 0(s1)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	sw	zero, 0(t4)
	j	.L0_3
.L0_3:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_1
.L0_4:
	lw	t4, 0(s4)
	lw	t5, 0(s5)
	lw	t4, 0(s5)
	mul	t4, t5, t4
	sw	t4, 20(sp)
	addi	t5, zero, 4
	lw	t4, 20(sp)
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	lw	t4, 20(sp)
	sw	t4, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s4)
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_5
.L0_5:
	lw	t5, 0(s11)
	lw	t6, 0(s5)
	lw	t4, 0(s5)
	mul	t4, t6, t4
	slt	t4, t5, t4
	beqz	t4, .L0_8
	j	.L0_6
.L0_6:
	lw	t5, 0(s4)
	lw	t4, 0(s11)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L0_7
.L0_7:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_5
.L0_8:
	lw	t4, 0(s7)
	lw	t4, 0(s5)
	sw	t4, 48(sp)
	addi	t5, zero, 4
	lw	t4, 48(sp)
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	lw	t4, 48(sp)
	sw	t4, 0(a0)
	addi	t4, a0, 4
	sw	t4, 0(s7)
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_9
.L0_9:
	lw	t4, 0(s11)
	lw	t5, 0(s5)
	slt	t4, t4, t5
	beqz	t4, .L0_16
	j	.L0_10
.L0_10:
	lw	t4, 0(s7)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t4, t4, t5
	sw	t4, 32(sp)
	lw	t4, 32(sp)
	lw	t4, 0(t4)
	lw	t4, 0(s5)
	sw	t4, 60(sp)
	addi	t5, zero, 4
	lw	t4, 60(sp)
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	lw	t4, 60(sp)
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lw	t5, 32(sp)
	sw	t4, 0(t5)
	lw	t4, 88(sp)
	lw	t4, 0(t4)
	lw	t4, 88(sp)
	sw	zero, 0(t4)
	j	.L0_11
.L0_11:
	lw	t4, 88(sp)
	lw	t4, 0(t4)
	lw	t5, 0(s5)
	slt	t4, t4, t5
	beqz	t4, .L0_14
	j	.L0_12
.L0_12:
	lw	t4, 0(s7)
	lw	t5, 0(s11)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 88(sp)
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	addi	t4, zero, -1
	sw	t4, 0(t5)
	j	.L0_13
.L0_13:
	lw	t4, 88(sp)
	lw	t4, 0(t4)
	addi	t4, t4, 1
	lw	t5, 88(sp)
	sw	t4, 0(t5)
	j	.L0_11
.L0_14:
	j	.L0_15
.L0_15:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_9
.L0_16:
	lw	t4, 0(s1)
	addi	t5, t4, 0
	lw	t4, 0(t5)
	lw	t4, 0(sp)
	lw	t4, 0(t4)
	sw	t4, 0(t5)
	lw	t4, 0(s4)
	addi	t4, t4, 0
	lw	t5, 0(t4)
	lw	t5, 68(sp)
	lw	t5, 0(t5)
	sw	t5, 0(t4)
	lw	t5, 0(s7)
	lw	t4, 0(sp)
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 68(sp)
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	sw	zero, 0(t5)
	j	.L0_17
.L0_17:
	lw	t4, 0(s2)
	lw	t5, 0(s10)
	slt	t4, t5, t4
	xori	t4, t4, 1
	beqz	t4, .L0_166
	j	.L0_18
.L0_18:
	lw	t4, 0(s8)
	lw	t6, 0(s7)
	lw	t5, 0(s1)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	slli	t4, t4, 2
	add	t4, t6, t4
	lw	t4, 0(t4)
	lw	t5, 0(s4)
	lw	t6, 0(s2)
	slli	t6, t6, 2
	add	t5, t5, t6
	lw	t5, 0(t5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	sw	t4, 0(s8)
	lw	t4, 0(s6)
	lw	t4, 0(s1)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, -1
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t4, 0(s4)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, -2
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_20
	j	.L0_21
.L0_19:
	addi	a0, zero, 0
	j	.L0_22
.L0_20:
	addi	a0, zero, 0
	j	.L0_22
.L0_21:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_22
.L0_22:
	beqz	a0, .L0_24
	j	.L0_25
.L0_23:
	addi	t4, zero, 0
	j	.L0_26
.L0_24:
	addi	t4, zero, 0
	j	.L0_26
.L0_25:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_26
.L0_26:
	beqz	t4, .L0_35
	j	.L0_27
.L0_27:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t4, 0(s1)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t4, 0(s4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	lw	t4, 0(s7)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s8)
	addi	t4, t4, 1
	sw	t4, 0(t5)
	lw	t4, 0(s6)
	lw	t5, 0(s9)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L0_29
	j	.L0_30
.L0_28:
	addi	t4, zero, 0
	j	.L0_31
.L0_29:
	addi	t4, zero, 0
	j	.L0_31
.L0_30:
	lw	t4, 0(s3)
	lw	t5, 28(sp)
	lw	t5, 0(t5)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_31
.L0_31:
	beqz	t4, .L0_33
	j	.L0_32
.L0_32:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_34
.L0_33:
	j	.L0_34
.L0_34:
	j	.L0_36
.L0_35:
	j	.L0_36
.L0_36:
	lw	t4, 0(s6)
	lw	t4, 0(s1)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, -1
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t5, 0(s4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 2
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_38
	j	.L0_39
.L0_37:
	addi	a0, zero, 0
	j	.L0_40
.L0_38:
	addi	a0, zero, 0
	j	.L0_40
.L0_39:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_40
.L0_40:
	beqz	a0, .L0_42
	j	.L0_43
.L0_41:
	addi	t4, zero, 0
	j	.L0_44
.L0_42:
	addi	t4, zero, 0
	j	.L0_44
.L0_43:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_44
.L0_44:
	beqz	t4, .L0_53
	j	.L0_45
.L0_45:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t5, 0(s1)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t4, 0(s4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t5, 0(s3)
	sw	t5, 0(t4)
	lw	t4, 0(s7)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t5, 0(s8)
	addi	t5, t5, 1
	sw	t5, 0(t4)
	lw	t4, 0(s6)
	lw	t5, 0(s9)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L0_47
	j	.L0_48
.L0_46:
	addi	t4, zero, 0
	j	.L0_49
.L0_47:
	addi	t4, zero, 0
	j	.L0_49
.L0_48:
	lw	t5, 0(s3)
	lw	t4, 28(sp)
	lw	t4, 0(t4)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_49
.L0_49:
	beqz	t4, .L0_51
	j	.L0_50
.L0_50:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_52
.L0_51:
	j	.L0_52
.L0_52:
	j	.L0_54
.L0_53:
	j	.L0_54
.L0_54:
	lw	t4, 0(s6)
	lw	t5, 0(s1)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t4, 0(s4)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, -2
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_56
	j	.L0_57
.L0_55:
	addi	a0, zero, 0
	j	.L0_58
.L0_56:
	addi	a0, zero, 0
	j	.L0_58
.L0_57:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_58
.L0_58:
	beqz	a0, .L0_60
	j	.L0_61
.L0_59:
	addi	t4, zero, 0
	j	.L0_62
.L0_60:
	addi	t4, zero, 0
	j	.L0_62
.L0_61:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_62
.L0_62:
	beqz	t4, .L0_71
	j	.L0_63
.L0_63:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t4, 0(s1)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t4, 0(s4)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	lw	t4, 0(s7)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t5, 0(s8)
	addi	t5, t5, 1
	sw	t5, 0(t4)
	lw	t5, 0(s6)
	lw	t4, 0(s9)
	sub	t4, t5, t4
	seqz	t4, t4
	beqz	t4, .L0_65
	j	.L0_66
.L0_64:
	addi	t4, zero, 0
	j	.L0_67
.L0_65:
	addi	t4, zero, 0
	j	.L0_67
.L0_66:
	lw	t4, 0(s3)
	lw	t5, 28(sp)
	lw	t5, 0(t5)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_67
.L0_67:
	beqz	t4, .L0_69
	j	.L0_68
.L0_68:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_70
.L0_69:
	j	.L0_70
.L0_70:
	j	.L0_72
.L0_71:
	j	.L0_72
.L0_72:
	lw	t4, 0(s6)
	lw	t5, 0(s1)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t4, 0(s4)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 2
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_74
	j	.L0_75
.L0_73:
	addi	a0, zero, 0
	j	.L0_76
.L0_74:
	addi	a0, zero, 0
	j	.L0_76
.L0_75:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_76
.L0_76:
	beqz	a0, .L0_78
	j	.L0_79
.L0_77:
	addi	t4, zero, 0
	j	.L0_80
.L0_78:
	addi	t4, zero, 0
	j	.L0_80
.L0_79:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_80
.L0_80:
	beqz	t4, .L0_89
	j	.L0_81
.L0_81:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t5, 0(s1)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t5, 0(s4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t5, 0(s3)
	sw	t5, 0(t4)
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s8)
	addi	t4, t4, 1
	sw	t4, 0(t5)
	lw	t4, 0(s6)
	lw	t5, 0(s9)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L0_83
	j	.L0_84
.L0_82:
	addi	t4, zero, 0
	j	.L0_85
.L0_83:
	addi	t4, zero, 0
	j	.L0_85
.L0_84:
	lw	t5, 0(s3)
	lw	t4, 28(sp)
	lw	t4, 0(t4)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_85
.L0_85:
	beqz	t4, .L0_87
	j	.L0_86
.L0_86:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_88
.L0_87:
	j	.L0_88
.L0_88:
	j	.L0_90
.L0_89:
	j	.L0_90
.L0_90:
	lw	t4, 0(s6)
	lw	t4, 0(s1)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, -2
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t5, 0(s4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, -1
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_92
	j	.L0_93
.L0_91:
	addi	a0, zero, 0
	j	.L0_94
.L0_92:
	addi	a0, zero, 0
	j	.L0_94
.L0_93:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_94
.L0_94:
	beqz	a0, .L0_96
	j	.L0_97
.L0_95:
	addi	t4, zero, 0
	j	.L0_98
.L0_96:
	addi	t4, zero, 0
	j	.L0_98
.L0_97:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_98
.L0_98:
	beqz	t4, .L0_107
	j	.L0_99
.L0_99:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t4, 0(s1)
	lw	t5, 0(s10)
	slli	t5, t5, 2
	add	t5, t4, t5
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t5, 0(s4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s8)
	addi	t4, t4, 1
	sw	t4, 0(t5)
	lw	t4, 0(s6)
	lw	t5, 0(s9)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L0_101
	j	.L0_102
.L0_100:
	addi	t4, zero, 0
	j	.L0_103
.L0_101:
	addi	t4, zero, 0
	j	.L0_103
.L0_102:
	lw	t4, 0(s3)
	lw	t5, 28(sp)
	lw	t5, 0(t5)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_103
.L0_103:
	beqz	t4, .L0_105
	j	.L0_104
.L0_104:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_106
.L0_105:
	j	.L0_106
.L0_106:
	j	.L0_108
.L0_107:
	j	.L0_108
.L0_108:
	lw	t4, 0(s6)
	lw	t5, 0(s1)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, -2
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t4, 0(s4)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_110
	j	.L0_111
.L0_109:
	addi	a0, zero, 0
	j	.L0_112
.L0_110:
	addi	a0, zero, 0
	j	.L0_112
.L0_111:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_112
.L0_112:
	beqz	a0, .L0_114
	j	.L0_115
.L0_113:
	addi	t4, zero, 0
	j	.L0_116
.L0_114:
	addi	t4, zero, 0
	j	.L0_116
.L0_115:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_116
.L0_116:
	beqz	t4, .L0_125
	j	.L0_117
.L0_117:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t5, 0(s1)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t5, 0(s4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t5, 0(s3)
	sw	t5, 0(t4)
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 0(s3)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t5, 0(s8)
	addi	t5, t5, 1
	sw	t5, 0(t4)
	lw	t5, 0(s6)
	lw	t4, 0(s9)
	sub	t4, t5, t4
	seqz	t4, t4
	beqz	t4, .L0_119
	j	.L0_120
.L0_118:
	addi	t4, zero, 0
	j	.L0_121
.L0_119:
	addi	t4, zero, 0
	j	.L0_121
.L0_120:
	lw	t4, 0(s3)
	lw	t5, 28(sp)
	lw	t5, 0(t5)
	sub	t4, t4, t5
	seqz	t4, t4
	j	.L0_121
.L0_121:
	beqz	t4, .L0_123
	j	.L0_122
.L0_122:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_124
.L0_123:
	j	.L0_124
.L0_124:
	j	.L0_126
.L0_125:
	j	.L0_126
.L0_126:
	lw	t4, 0(s6)
	lw	t4, 0(s1)
	lw	t5, 0(s2)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t4, 0(t4)
	addi	t4, t4, 2
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t5, 0(s4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, -1
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_128
	j	.L0_129
.L0_127:
	addi	a0, zero, 0
	j	.L0_130
.L0_128:
	addi	a0, zero, 0
	j	.L0_130
.L0_129:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_130
.L0_130:
	beqz	a0, .L0_132
	j	.L0_133
.L0_131:
	addi	t4, zero, 0
	j	.L0_134
.L0_132:
	addi	t4, zero, 0
	j	.L0_134
.L0_133:
	lw	t4, 0(s7)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_134
.L0_134:
	beqz	t4, .L0_143
	j	.L0_135
.L0_135:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t5, 0(s1)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t5, 0(s4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	lw	t4, 0(s7)
	lw	t5, 0(s6)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t5, 0(s8)
	addi	t5, t5, 1
	sw	t5, 0(t4)
	lw	t5, 0(s6)
	lw	t4, 0(s9)
	sub	t4, t5, t4
	seqz	t4, t4
	beqz	t4, .L0_137
	j	.L0_138
.L0_136:
	addi	t4, zero, 0
	j	.L0_139
.L0_137:
	addi	t4, zero, 0
	j	.L0_139
.L0_138:
	lw	t5, 0(s3)
	lw	t4, 28(sp)
	lw	t4, 0(t4)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_139
.L0_139:
	beqz	t4, .L0_141
	j	.L0_140
.L0_140:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_142
.L0_141:
	j	.L0_142
.L0_142:
	j	.L0_144
.L0_143:
	j	.L0_144
.L0_144:
	lw	t4, 0(s6)
	lw	t5, 0(s1)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 2
	sw	t4, 0(s6)
	lw	t4, 0(s3)
	lw	t5, 0(s4)
	lw	t4, 0(s2)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	sw	t4, 0(s3)
	lw	a0, 0(s6)
	lw	a1, 0(s5)
	call	check
	beqz	a0, .L0_146
	j	.L0_147
.L0_145:
	addi	a0, zero, 0
	j	.L0_148
.L0_146:
	addi	a0, zero, 0
	j	.L0_148
.L0_147:
	lw	a0, 0(s3)
	lw	a1, 0(s5)
	call	check
	j	.L0_148
.L0_148:
	beqz	a0, .L0_150
	j	.L0_151
.L0_149:
	addi	t4, zero, 0
	j	.L0_152
.L0_150:
	addi	t4, zero, 0
	j	.L0_152
.L0_151:
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	addi	t4, t4, 1
	seqz	t4, t4
	j	.L0_152
.L0_152:
	beqz	t4, .L0_161
	j	.L0_153
.L0_153:
	lw	t4, 0(s10)
	lw	t4, 0(s10)
	addi	t4, t4, 1
	sw	t4, 0(s10)
	lw	t5, 0(s1)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s6)
	sw	t4, 0(t5)
	lw	t5, 0(s4)
	lw	t4, 0(s10)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s3)
	sw	t4, 0(t5)
	lw	t5, 0(s7)
	lw	t4, 0(s6)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t5, 0(t4)
	lw	t4, 0(s3)
	slli	t4, t4, 2
	add	t5, t5, t4
	lw	t4, 0(t5)
	lw	t4, 0(s8)
	addi	t4, t4, 1
	sw	t4, 0(t5)
	lw	t4, 0(s6)
	lw	t5, 0(s9)
	sub	t4, t4, t5
	seqz	t4, t4
	beqz	t4, .L0_155
	j	.L0_156
.L0_154:
	addi	t4, zero, 0
	j	.L0_157
.L0_155:
	addi	t4, zero, 0
	j	.L0_157
.L0_156:
	lw	t5, 0(s3)
	lw	t4, 28(sp)
	lw	t4, 0(t4)
	sub	t4, t5, t4
	seqz	t4, t4
	j	.L0_157
.L0_157:
	beqz	t4, .L0_159
	j	.L0_158
.L0_158:
	lw	t4, 0(s0)
	addi	t4, zero, 1
	sw	t4, 0(s0)
	j	.L0_160
.L0_159:
	j	.L0_160
.L0_160:
	j	.L0_162
.L0_161:
	j	.L0_162
.L0_162:
	lw	t4, 0(s0)
	addi	t4, t4, -1
	seqz	t4, t4
	beqz	t4, .L0_164
	j	.L0_163
.L0_163:
	j	.L0_166
	j	.L0_165
.L0_164:
	j	.L0_165
.L0_165:
	lw	t4, 0(s2)
	lw	t4, 0(s2)
	addi	t4, t4, 1
	sw	t4, 0(s2)
	j	.L0_17
.L0_166:
	lw	t4, 0(s0)
	addi	t4, t4, -1
	seqz	t4, t4
	beqz	t4, .L0_168
	j	.L0_167
.L0_167:
	lw	t5, 0(s7)
	lw	t4, 0(s9)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lw	t5, 28(sp)
	lw	t5, 0(t5)
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	a0, 0(t4)
	call	mx__toString
	call	mx__println
	j	.L0_169
.L0_168:
	la	a0, .str.0
	call	mx__print
	j	.L0_169
.L0_169:
	lw	t4, 36(sp)
	sw	zero, 0(t4)
	j	.L0_171
.L0_170:
	j	.L0_171
.L0_171:
	lw	t4, 36(sp)
	lw	a0, 0(t4)
	lw	s11, 52(sp)
	lw	s10, 76(sp)
	lw	s0, 24(sp)
	lw	s1, 72(sp)
	lw	s2, 16(sp)
	lw	s3, 44(sp)
	lw	s4, 84(sp)
	lw	s5, 8(sp)
	lw	s6, 40(sp)
	lw	s7, 4(sp)
	lw	s8, 56(sp)
	lw	s9, 64(sp)
	lw	ra, 80(sp)
	addi	sp, sp, 92
	ret
	.size	main, .-main
	.globl	check
	.p2align	2
	.type	check,@function
check:
.L1_0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s11, 4(sp)
	sw	s10, 8(sp)
	sw	s5, 0(sp)
	mv	s10, a0
	mv	s11, a1
	addi	a0, zero, 1
	call	malloc
	mv	s5, a0
	sb	zero, 0(s5)
	addi	a0, zero, 4
	call	malloc
	sw	s10, 0(a0)
	lw	t4, 0(a0)
	slt	t4, t4, s11
	beqz	t4, .L1_2
	j	.L1_3
.L1_1:
	addi	t4, zero, 0
	j	.L1_4
.L1_2:
	addi	t4, zero, 0
	j	.L1_4
.L1_3:
	lw	t4, 0(a0)
	slt	t4, t4, zero
	xori	t4, t4, 1
	j	.L1_4
.L1_4:
	sb	t4, 0(s5)
	j	.L1_6
.L1_5:
	j	.L1_6
.L1_6:
	lb	a0, 0(s5)
	lw	s11, 4(sp)
	lw	s10, 8(sp)
	lw	s5, 0(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
	.size	check, .-check
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
	.str.0:
	.asciz	"no solution!\n "
