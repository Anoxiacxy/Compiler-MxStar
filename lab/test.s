	.text

	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L0_0:
	ret
	.size	mx__init, .-mx__init
	.globl	test
	.p2align	2
	.type	test,@function
test:
.L1_0:
	addi	a0, zero, 0
	addi	t0, zero, 0
	j	.L1_1
.L1_1:
	addi	t1, zero, 200
	slt	t1, t0, t1
	beqz	t1, .L1_3
	j	.L1_2
.L1_2:
	addi	t0, t0, 1
	addi	a0, a0, 1
	addi	t0, t0, 1
	j	.L1_1
.L1_3:
	ret
	.size	test, .-test
	.globl	naivedce
	.p2align	2
	.type	naivedce,@function
naivedce:
.L2_0:
	addi	t0, zero, 1
	addi	t2, zero, 0
	j	.L2_1
.L2_1:
	addi	t1, zero, 100
	slt	t1, t1, t0
	xori	t1, t1, 1
	beqz	t1, .L2_3
	j	.L2_2
.L2_2:
	add	t2, t2, t0
	addi	t0, t0, 1
	j	.L2_1
.L2_3:
	j	.L2_4
.L2_4:
	addi	t1, zero, 1
	slt	t1, t0, t1
	xori	t1, t1, 1
	beqz	t1, .L2_6
	j	.L2_5
.L2_5:
	add	t2, t2, t0
	addi	t0, t0, -1
	j	.L2_4
.L2_6:
	addi	t0, t0, 1
	addi	t1, zero, 1
	j	.L2_7
.L2_7:
	addi	a0, zero, 10
	slt	a0, a0, t0
	xori	a0, a0, 1
	beqz	a0, .L2_9
	j	.L2_8
.L2_8:
	mul	t1, t1, t0
	addi	t0, t0, 1
	j	.L2_7
.L2_9:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_113
	j	.L2_10
.L2_10:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_111
	j	.L2_11
.L2_11:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_109
	j	.L2_12
.L2_12:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_107
	j	.L2_13
.L2_13:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_105
	j	.L2_14
.L2_14:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_103
	j	.L2_15
.L2_15:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_101
	j	.L2_16
.L2_16:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_99
	j	.L2_17
.L2_17:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_97
	j	.L2_18
.L2_18:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_95
	j	.L2_19
.L2_19:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_93
	j	.L2_20
.L2_20:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_91
	j	.L2_21
.L2_21:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_89
	j	.L2_22
.L2_22:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_87
	j	.L2_23
.L2_23:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_85
	j	.L2_24
.L2_24:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_83
	j	.L2_25
.L2_25:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_81
	j	.L2_26
.L2_26:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_79
	j	.L2_27
.L2_27:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_77
	j	.L2_28
.L2_28:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_75
	j	.L2_29
.L2_29:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_73
	j	.L2_30
.L2_30:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_71
	j	.L2_31
.L2_31:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_69
	j	.L2_32
.L2_32:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_67
	j	.L2_33
.L2_33:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_65
	j	.L2_34
.L2_34:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_63
	j	.L2_35
.L2_35:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_61
	j	.L2_36
.L2_36:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_59
	j	.L2_37
.L2_37:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_57
	j	.L2_38
.L2_38:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_55
	j	.L2_39
.L2_39:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_53
	j	.L2_40
.L2_40:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_51
	j	.L2_41
.L2_41:
	li	t0, 3628800
	sub	t0, t1, t0
	seqz	t0, t0
	beqz	t0, .L2_49
	j	.L2_42
.L2_42:
	li	t0, 10100
	sub	t0, t2, t0
	seqz	t0, t0
	beqz	t0, .L2_47
	j	.L2_43
.L2_43:
	li	t0, 3628800
	sub	t0, t1, t0
	seqz	t0, t0
	beqz	t0, .L2_45
	j	.L2_44
.L2_44:
	j	.L2_46
.L2_45:
	j	.L2_46
.L2_46:
	j	.L2_48
.L2_47:
	j	.L2_48
.L2_48:
	j	.L2_50
.L2_49:
	j	.L2_50
.L2_50:
	j	.L2_52
.L2_51:
	j	.L2_52
.L2_52:
	j	.L2_54
.L2_53:
	j	.L2_54
.L2_54:
	j	.L2_56
.L2_55:
	j	.L2_56
.L2_56:
	j	.L2_58
.L2_57:
	j	.L2_58
.L2_58:
	j	.L2_60
.L2_59:
	j	.L2_60
.L2_60:
	j	.L2_62
.L2_61:
	j	.L2_62
.L2_62:
	j	.L2_64
.L2_63:
	j	.L2_64
.L2_64:
	j	.L2_66
.L2_65:
	j	.L2_66
.L2_66:
	j	.L2_68
.L2_67:
	j	.L2_68
.L2_68:
	j	.L2_70
.L2_69:
	j	.L2_70
.L2_70:
	j	.L2_72
.L2_71:
	j	.L2_72
.L2_72:
	j	.L2_74
.L2_73:
	j	.L2_74
.L2_74:
	j	.L2_76
.L2_75:
	j	.L2_76
.L2_76:
	j	.L2_78
.L2_77:
	j	.L2_78
.L2_78:
	j	.L2_80
.L2_79:
	j	.L2_80
.L2_80:
	j	.L2_82
.L2_81:
	j	.L2_82
.L2_82:
	j	.L2_84
.L2_83:
	j	.L2_84
.L2_84:
	j	.L2_86
.L2_85:
	j	.L2_86
.L2_86:
	j	.L2_88
.L2_87:
	j	.L2_88
.L2_88:
	j	.L2_90
.L2_89:
	j	.L2_90
.L2_90:
	j	.L2_92
.L2_91:
	j	.L2_92
.L2_92:
	j	.L2_94
.L2_93:
	j	.L2_94
.L2_94:
	j	.L2_96
.L2_95:
	j	.L2_96
.L2_96:
	j	.L2_98
.L2_97:
	j	.L2_98
.L2_98:
	j	.L2_100
.L2_99:
	j	.L2_100
.L2_100:
	j	.L2_102
.L2_101:
	j	.L2_102
.L2_102:
	j	.L2_104
.L2_103:
	j	.L2_104
.L2_104:
	j	.L2_106
.L2_105:
	j	.L2_106
.L2_106:
	j	.L2_108
.L2_107:
	j	.L2_108
.L2_108:
	j	.L2_110
.L2_109:
	j	.L2_110
.L2_110:
	j	.L2_112
.L2_111:
	j	.L2_112
.L2_112:
	j	.L2_114
.L2_113:
	j	.L2_114
.L2_114:
	addi	a0, zero, 1919
	ret
	.size	naivedce, .-naivedce
	.globl	dceconst
	.p2align	2
	.type	dceconst,@function
dceconst:
.L3_0:
	addi	t0, zero, 0
	j	.L3_1
.L3_1:
	lui	t1, %hi(N)
	lw	t1, %lo(N)(t1)
	slt	t1, t0, t1
	beqz	t1, .L3_6
	j	.L3_2
.L3_2:
	addi	t1, zero, 0
	j	.L3_3
.L3_3:
	lui	t2, %hi(N)
	lw	t2, %lo(N)(t2)
	slt	t2, t1, t2
	beqz	t2, .L3_5
	j	.L3_4
.L3_4:
	addi	t1, t1, 1
	j	.L3_3
.L3_5:
	addi	t0, t0, 1
	j	.L3_1
.L3_6:
	addi	t0, zero, 0
	j	.L3_7
.L3_7:
	lui	t1, %hi(N)
	lw	t1, %lo(N)(t1)
	slt	t1, t0, t1
	beqz	t1, .L3_9
	j	.L3_8
.L3_8:
	addi	t0, t0, 1
	j	.L3_7
.L3_9:
	li	a0, 114514
	ret
	.size	dceconst, .-dceconst
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L4_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	sw	s9, 8(sp)
	sw	s10, 0(sp)
	call	test
	mv	s9, a0
	call	naivedce
	add	s9, s9, a0
	call	dceconst
	add	t0, s9, a0
	li	ra, 50997
	sub	a0, t0, ra
	lw	s9, 8(sp)
	lw	s10, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	main, .-main

	.section	.sdata,"aw",@progbits
	.global	N
	.p2align	2
	N:
	.word	80                      # 80
