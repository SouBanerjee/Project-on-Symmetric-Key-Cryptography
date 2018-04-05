#include<stdio.h>
int main()
{
 FILE *fp;
 char f[25],e[25];
 int i,j,fc,fo=0,fo_a[256],fe=0,fe_a[256],df_counter=0;;
 float ch_sq_a[256],ch_sq=0.0;
 printf("\nEnter the name of the source file(with extension) : ");
 scanf("%s",f);
 for(i=0;i<=255;i++)
  fe_a[i]=0;
 fp=fopen(f,"r+");
 for(i=0;(fc=fgetc(fp))!=EOF;i++)
  fe_a[fc]=fe_a[fc]+1;
 fclose(fp);
 printf("\nEnter the name of the encrypted file(with extension) : ");
 scanf("%s",e);
 for(i=0;i<=255;i++)
  fo_a[i]=0;
 fp=fopen(e,"r+");
 for(i=0;(fc=fgetc(fp))!=EOF;i++)
	fo_a[fc]=fo_a[fc]+1;
 fclose(fp);
 for(i=0;i<=255;i++)
  {
	if(fe_a[i]!=0)
	 ch_sq_a[i]=(fo_a[i]-fe_a[i])*(fo_a[i]-fe_a[i])/fe_a[i];
  }
 for(i=0;i<=255;i++)
  ch_sq=ch_sq+ch_sq_a[i];
 printf("Chi-square value= %f",ch_sq);
 for(i=0;i<=255;i++)
  {
	if(fe_a[i]!=0 && fo_a[i]!=0)
	 df_counter=df_counter+1;
	else if(fe_a[i]!=0 && fo_a[i]==0)
	 df_counter=df_counter+1;
	else if(fe_a[i]==0 && fo_a[i]!=0)
	 df_counter=df_counter+1;
	else
	 df_counter=df_counter+0;
  }
 printf("\nDegree of Freedom= %d",df_counter-1);
 return 0;
}
