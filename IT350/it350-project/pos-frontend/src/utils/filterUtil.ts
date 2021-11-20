export const filterProducts = (product: any, inputPar: string) => {
  return [product.name, product.productType.name].some(prop => prop.toLowerCase().startsWith(inputPar.toLowerCase()));
};
